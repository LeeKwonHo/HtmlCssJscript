//백그라운드
var canvas = document.getElementById("myCanvas");
var ctx = canvas.getContext("2d");
//점수 변수
var score = 0;
//공 크기
var ballRadius = 3;
var ballColor = "#0095DD";
//공 시작지점
var x = Math.random() * (canvas.width - 2 * ballRadius) + ballRadius;
var y = canvas.height - 10;
//공의 속도
var dx = 1;//1
var dy = -1;//1
//받침대 크기
var paddleHeight = 5;
var paddleWidth = 150;
var paddleX = (canvas.width - paddleWidth) / 2;
var paddleColor = "#0095DD";
//키보드 변수
var rightPressed = false;
var leftPressed = false;
//벽돌 변수
var brickRowCount = 70; //70
var brickColumnCount = 98; //108
var brickWidth = 15; //15
var brickHeight = 4; //4
var brickPadding = 4; //4
var brickOffsetTop = 24; //24
var brickOffsetLeft = 23; //23

var bricks = [];
for (var c = 0; c < brickColumnCount; c++) {
	bricks[c] = [];
	for (var r = 0; r < brickRowCount; r++) {
		bricks[c][r] = { x: 0, y: 0, status: 1, color: getRandomColor() };
	}
}
//좌우 키보드
document.addEventListener("keydown", keyDownHandler, false);
document.addEventListener("keyup", keyUpHandler, false);

function keyDownHandler(e) {
	if (e.key == "Right" || e.key == "ArrowRight") {
		rightPressed = true;
	}
	else if (e.key == "Left" || e.key == "ArrowLeft") {
		leftPressed = true;
	}
}

function keyUpHandler(e) {
	if (e.key == "Right" || e.key == "ArrowRight") {
		rightPressed = false;
	}
	else if (e.key == "Left" || e.key == "ArrowLeft") {
		leftPressed = false;
	}
}

//충돌 계산
function collisionDetection() {
	var hasBricksLeft = false;
	for (var c = 0; c < brickColumnCount; c++) {
		for (var r = 0; r < brickRowCount; r++) {
			var b = bricks[c][r];
			if (b.status == 1) {
				hasBricksLeft = true;
				if (
					x > b.x &&
					x < b.x + brickWidth &&
					y > b.y &&
					y < b.y + brickHeight
				) {

					var randomColor = getRandomColor();
					// 공의 색상을 변경
					ballColor = randomColor;

					// 계산된 각도로 반사
					var brickCenterX = b.x + brickWidth / 2;
					var angle = Math.atan2(y - (b.y + brickHeight / 2), x - brickCenterX);
					dx = 2 * Math.cos(angle);
					dy = 2 * Math.sin(angle);
					b.status = 0;
					score++;


				}
			}
		}
	}

	// 패들과의 충돌 처리
	if (y + dy > canvas.height - ballRadius) {
		if (x > paddleX && x < paddleX + paddleWidth) {
			// 패들에서의 충돌 처리
			var paddleCenterX = paddleX + paddleWidth / 2;
			var deviation = x - paddleCenterX;
			var angle = (deviation / (paddleWidth / 2)) * (Math.PI / 3); // 최대 60도로 제한
			dx = 2 * Math.sin(angle);
			dy = -2 * Math.cos(angle);
		}
	}

	if (!hasBricksLeft) {
		alert("OK~ Let's GO!");
		createBricks();
		drawBricks(); // 새로운 벽돌 생성
	}
}

//점수 표시
function drawScore() {
	ctx.font = "16px Arial";
	ctx.fillStyle = "#0095DD";
	ctx.fillText("Score: " + score, 8, 20);
}
//공 표시
function drawBall() {
	ctx.beginPath();
	ctx.arc(x, y, ballRadius, 0, Math.PI * 2);
	ctx.fillStyle = ballColor; // 공의 색상 설정
	ctx.fill();
	ctx.closePath();
}
//받침대 표시
function drawPaddle() {
	ctx.beginPath();
	ctx.rect(paddleX, canvas.height - paddleHeight, paddleWidth, paddleHeight);
	ctx.fillStyle = paddleColor;
	ctx.fill();
	ctx.closePath();
}
//벽돌 표시
function drawBricks() {
	for (var c = 0; c < brickColumnCount; c++) {
		for (var r = 0; r < brickRowCount; r++) {
			if (bricks[c][r].status == 1) {
				var brickX = (c * (brickWidth + brickPadding)) + brickOffsetLeft;
				var brickY = (r * (brickHeight + brickPadding)) + brickOffsetTop;
				bricks[c][r].x = brickX;
				bricks[c][r].y = brickY;
				ctx.beginPath();
				ctx.rect(brickX, brickY, brickWidth, brickHeight);
				//let randomColor = getRandomColor();
				ctx.fillStyle = bricks[c][r].color;
				ctx.fill();
				ctx.closePath();
			}
		}
	}
}
//전체 화면
function draw() {
	ctx.clearRect(0, 0, canvas.width, canvas.height);
	drawBricks();
	drawBall();
	drawPaddle();
	collisionDetection();
	drawScore();

	if (x + dx > canvas.width - ballRadius || x + dx < ballRadius) {
		dx = -dx;
	}
	if (y + dy < ballRadius) {
		dy = -dy;
	}
	else if (y + dy > canvas.height - ballRadius) {
		if (x > paddleX && x < paddleX + paddleWidth) {
			if (y = y - paddleHeight) {
				dy = -dy;
			}
		}
		else {
			alert("You Loser");
			document.location.reload();
			clearInterval(interval);
		}
	}

	if (rightPressed && paddleX < canvas.width - paddleWidth) {
		paddleX += 4;
	}
	else if (leftPressed && paddleX > 0) {
		paddleX -= 4;
	}

	x += dx;
	y += dy;
}

function getRandomColor() {
	var r = Math.floor(Math.random() * 256);
	var g = Math.floor(Math.random() * 256);
	var b = Math.floor(Math.random() * 256);
	var randomColor = "rgb(" + r + "," + g + "," + b + ")";

	// 랜덤 색상이 캔버스 배경색과 겹치는 경우 다른 색상으로 변경
	while (randomColor === "#eee") {
		r = Math.floor(Math.random() * 256);
		g = Math.floor(Math.random() * 256);
		b = Math.floor(Math.random() * 256);
		randomColor = "rgb(" + r + "," + g + "," + b + ")";
	}

	return randomColor;
}

//공의 속도
var interval = setInterval(draw, 1);

