from rest_framework import serializers
import re
from Common.regex import remail,rpassword
from Common.messenge import WRONG_FORM_EMAIL,WRONG_FORM_PASSWORD
class RegisterSerializer(serializers.Serializer):
    
    email = serializers.EmailField()
    password = serializers.CharField(min_length=8)  

    def validate(self, data):
        if not re.match(remail,data['email']) :
            raise serializers.ValidationError(WRONG_FORM_EMAIL)
        elif not re.match(rpassword,data['password']):
            raise serializers.ValidationError(WRONG_FORM_PASSWORD)
        return data
