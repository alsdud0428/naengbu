from flask import Flask, render_template

app = Flask(__name__)

# 홈페이지 라우트
@app.route('/')
def index():
    return render_template('templates.html')

# 로그인 라우트
@app.route('/login')
def login():
    return '로그인 페이지입니다.'

# 회원가입 라우트
@app.route('/signin')
def signin():
    return '회원가입 페이지입니다.'

if __name__ == '__main__':
    app.run(debug=True)
