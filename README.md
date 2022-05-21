# algostudy-java
📝캐치스터디 24기 자바 알고리즘 스터디


---------------------------------------------------------------------------------------------------------------------------------------------

---------------------------------------------------------------------------------------------------------------------------------------------
## 🧐Git Fork 가이드


### 👇아래 1~4번은 최초 1회만 실행
1. https://github.com/song960530/algostudy-java 레포지토리 우측 상단 Fork 아이콘 클릭

![fork1](https://user-images.githubusercontent.com/52727315/169644285-b4fcceea-50a5-4e6f-8201-c1f8b014e884.png)

2. fork 된 개인 레포지토리의 ULR 복사

![fork2](https://user-images.githubusercontent.com/52727315/169644319-20b0bc98-b66c-4d1b-9688-7de06936917d.png)

3. 다운로드 받을 경로로 이동하여 로컬Repo로 clone
```
git clone [내 원격Repo주소]
ex)git clone https://github.com/song960530/algostudy-java
```
4. 로컬Repo의 upstream이란 브랜치에 포크한 Repo를 연결한다
```
git remote add upstream [포크한 Repo주소]
아래 명령어 실행
git remote add upstream https://github.com/song960530/algostudy-java
```  
<br>  
<br>  
<br>  

### 👇아래 1~7번은 작업할때마다 반복 실행

1. 로컬Repo에 포크한 Repo의 업데이트 내역 불러오기
```
git fetch upstream
```
2. 작업할 브랜치 생성
```
git checkout -b [브래내치명] [복사할 브랜치명]
ex) git checkout -b feature/week1송문준 upstream/main
```
3. ✨자유롭게 문제풀이 시작~✨
4. 문제풀이 완료시 작업한 브랜치 -> 원격Repo로 push
```
git add .
git fetch upstream  ### push 하기 전 변경사항 한번 다시 적용해주기
git merge upstream/main ### push 하기 전 변경사항 한번 다시 적용해주기
git commit -m "커밋 메세지"
git push origin feature/week1송문준
```
5. 깃헙 원격Repo로 이동하여 상단 Compare & pull request 버튼 클릭

![PR1](https://user-images.githubusercontent.com/52727315/169644557-56557850-fed9-4020-805b-275210efa123.png)

6. 포크한Repo로 PR 날리기

![PR2](https://user-images.githubusercontent.com/52727315/169644623-eec4c01c-3c4d-45a1-badb-8fbcc6277045.png)

7. 이후 PR날렸다고 알려주시면 됩니다👏
