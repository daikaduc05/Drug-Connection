from django.db import models
from user.models import Users
# Create your models here.

class ChatBox(models.Model):
    user1 = models.ForeignKey(Users,related_name="chatbox1",on_delete=models.CASCADE)
    user2 = models.ForeignKey(Users,related_name="chatbox2",on_delete=models.CASCADE)
    is_block = models.BooleanField()

class Messenge(models.Model):
    from_user = models.ForeignKey(Users,related_name="sendmess",on_delete=models.CASCADE)
    to_user = models.ForeignKey(Users,related_name="receivemess",on_delete=models.CASCADE)
    content = models.TextField()
    seen = models.BooleanField()