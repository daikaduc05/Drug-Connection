from .models import Users
from django.utils import timezone
import bcrypt
import jwt
import os
from django.http import JsonResponse
class UserService:
    def create(password,email):
        password_bytes = password.encode('utf-8')
        hash_password = bcrypt.hashpw(password_bytes, bcrypt.gensalt(10))
        created_at = timezone.now()
        Users.objects.create(email = email
        ,password = hash_password.decode('utf-8')
        ,join_at = created_at)
        user = Users.objects.get(email = email)
        return user.id

    def authen_account(email,password):
        user = Users.objects.get(email = email)
        if(user.authenticate(password=password)):
            return user.id
        else:
            return None

    def gen_jwt(email):
        payload = {
            'email' : email,
        }
        token = jwt.encode(payload=payload,key=os.getenv("JWT_SECRET"),algorithm='HS256')
        return token

    def decode_jwt(token):
        try:
            decoded_payload = jwt.decode(token,os.getenv("JWT_SECRET"),algorithms=['HS256'])
            user = Users.objects.get(email = decoded_payload['email'])
            
            if user :
                return user.id
            else:
                return None
        except jwt.InvalidTokenError:
            return None

    def jwt_required(request):
        auth_header = request.headers['Authorization']
        
        if not auth_header:
            return JsonResponse({'message': 'Authorization header missing'}, status=401)

        try:
            token_type, token = auth_header.split()
            if token_type != 'Bearer':
                return JsonResponse({'message': 'Invalid token type'}, status=401)
           # print (UserService.decode_jwt(token))
            user_id = UserService.decode_jwt(token)
            if user_id is None:
                return JsonResponse({'message': 'Invalid token'}, status=401)

            return JsonResponse({'message': 'ok',
                'user_id' : user_id
            
            }, status=201)  
        except ValueError:
            return JsonResponse({'message': 'Invalid token header'}, status=401)
        
    
    
        