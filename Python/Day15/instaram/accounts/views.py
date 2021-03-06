from django.shortcuts import render, redirect
# django에 정의된 기능 불러오기
from django.contrib.auth.models import User # User model
from django.contrib.auth.forms import UserCreationForm, AuthenticationForm 
# UserCreationForm : 회원가입 / AuthenticationForm : 로그인 시 정보 확인
from django.contrib.auth import login as auth_login
from django.contrib.auth import logout as auth_logout

# Create your views here.
def signup(request):
    if request.method == "POST":
        form = UserCreationForm(request.POST)
        if form.is_valid():
            user = form.save() # 회원가입
            auth_login(request, user) # 로그인
            return redirect('articles') # redirect는 새롭게 페이지 연결
        else: 
            return render(request, 'signup.html')
    else:
        if request.user.is_authenticated:
            # 회원가입을 하고 로그인을 했으면, 회원가입 사이트로 가면 안돼
            return redirect('articles')
        else:
            return render(request, 'signup.html')

def login(request):
    if request.method == "POST":
        form = AuthenticationForm(request, request.POST)
        if form.is_valid():
            # form이 맞다면?
            auth_login(request, form.get_user())
            return redirect('articles')
        else:
            return render(request, 'login.html')
    else:
        if request.user.is_authenticated:
            return redirect('articles')
        else:
            return render(request, 'login.html')

def logout(request):
    auth_logout(request)
    return redirect('articles')


