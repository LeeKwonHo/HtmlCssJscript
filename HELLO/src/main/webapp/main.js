/**
 * 
 */
function dis() {
	let i, j, k;
	i = 1;
	j = 2;
	k = i + j;
	console.log(k + i + j);
	let a = [];

	let n = 0;
	for (let o = 1; o < 101; o++) {
		if (o % 2 == 0) {
			n += o;
		}

		console.log(n);

		a[o] = o;
		if (o == 100) {
			a[o] = 'how arry move';
		}
	}
	//console.log(a);

	for (let m = 0; m < a.length; m++) {
		console.log(a[m]);

	}

	window.alert('안녕');
	document.getElementById("예제").innerHTML = Date()
}
