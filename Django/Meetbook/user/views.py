from django.shortcuts import render
from rest_framework.views import APIView
from rest_framework.response import Response
from .serializer import RegisterSerializer
from .service import UserService
from rest_framework import status
from django.db import IntegrityError
from django.http import JsonResponse
from Common.messenge import INTERGRITY_EMAIL
from django.core.exceptions import ObjectDoesNotExist
from functools import wraps


class Register(APIView):
    def post(self,request,format = None):
        try:
            serialize = RegisterSerializer(data = request.data)
            if(serialize.is_valid()):  
                id = UserService.create(request.data['password'],
                request.data['email']
                )   
                data ={
                    "user id" : id,
                    "messenge" : "created"
                }
                return JsonResponse(data,status = status.HTTP_201_CREATED)
            else:
                return Response(serialize.errors,status=status.HTTP_400_BAD_REQUEST)
        except IntegrityError:
                return Response(INTERGRITY_EMAIL,status=status.HTTP_400_BAD_REQUEST)

class Login(APIView):
    def post(self,request,format = None):
        email = request.data['email']
        password = request.data['password']
        try:
            if UserService.authen_account(email=email,password=password):
                token = UserService.gen_jwt(email=email)       
                data = {
                    "user id" : UserService.authen_account(email=email,password=password),
                    "token" : token,
                    "messenge" : "login successful"
                }
                return JsonResponse(data=data
                    ,status = status.HTTP_200_OK
                )
            else:
                data = {
                    "messenge" : "fail"
                }
                return JsonResponse(
                    data=data
                    ,status = status.HTTP_401_UNAUTHORIZED
                )
        except ObjectDoesNotExist:
            data = {
                "messenge" : "account does not exist"
            }
            return JsonResponse(
                data=data,
                status = status.HTTP_401_UNAUTHORIZED
            )
     
class Home(APIView):
    def get(self,request,format = None):
        if UserService.jwt_required(request).get('user_id') :
            data = {
                'id' : UserService.jwt_required(request).get('user_id')
            }
            return JsonResponse(data)
        else :
            return UserService.jwt_required(request) 