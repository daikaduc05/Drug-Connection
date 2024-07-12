from django.db import models
from user.models import Users
# Create your models here.
class Post(models.Model):
    title = models.CharField(max_length=255)
    body = models.TextField()
    picture = models.URLField()
    user = models.ForeignKey(Users,related_name="posts", on_delete=models.CASCADE)
    created_at = models.DateTimeField(auto_now_add=True)
    def __str__(self):
        return self.title

class Comment(models.Model):
    content = models.TextField()
    user = models.ForeignKey(Users, on_delete=models.CASCADE)
    post = models.ForeignKey(Post,related_name="comment",on_delete=models.CASCADE)
    create_at = models.DateTimeField(auto_now_add=True)

class React(models.Model):
    post = models.ForeignKey(Post,related_name="react",on_delete=models.CASCADE)
    user = models.ForeignKey(Users,on_delete=models.CASCADE)
    create_at = models.DateTimeField(auto_now=True)

class Nofitication(models.Model):
    user = models.ForeignKey(Users,related_name="Notification",on_delete=models.CASCADE)
    content = models.TextField()
    create_at = models.TimeField()
