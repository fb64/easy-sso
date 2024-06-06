from flask import Flask, render_template, request

app = Flask(__name__)


@app.route('/')
def hello():
    return render_template('hello.html')


@app.route('/headers')
def headers():
    return render_template('headers.html', headers=request.headers.items())


if __name__ == '__main__':
    app.run(host='0.0.0.0', debug=True)
