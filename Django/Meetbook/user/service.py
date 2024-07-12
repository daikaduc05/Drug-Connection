from .models import Users
from django.utils import timezone
import bcrypt
class UserService:
    def create(password,email):
        password_bytes = password.encode('utf-8')
        hash_password = bcrypt.hashpw(password_bytes, bcrypt.gensalt(10))
        created_at = timezone.now()
        Users.objects.create(email = email
        ,password = hash_password.decode('utf-8')
        ,join_at = created_at)
        
    