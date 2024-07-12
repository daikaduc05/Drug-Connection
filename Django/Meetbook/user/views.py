from django.shortcuts import render
from rest_framework.views import APIView
from rest_framework.response import Response
from .serializer import RegisterSerializer
from .service import UserService
from rest_framework import status
from django.db import IntegrityError
from Common.messenge import INTERGRITY_EMAIL
class Register(APIView):
    def post(self,request,format = None):
        try:
            serialize = RegisterSerializer(data = request.data)
            if(serialize.is_valid()):  
                UserService.create(request.data['password'],
                request.data['email']
                )   
                return Response("Created",status=status.HTTP_201_CREATED)
            else:
                return Response(serialize.errors,status=status.HTTP_400_BAD_REQUEST)
        except IntegrityError:
                return Response(INTERGRITY_EMAIL,status=status.HTTP_400_BAD_REQUEST)