/**
 * jason2.js
 */

document.querySelector('div.container-fluid>div:nth-of-type(2)').remove();
document.querySelector('div.container-fluid>table').remove();

let json = `[{"id":1,"first_name":"Clemente","last_name":"Pidon","email":"cpidon0@noaa.gov","gender":"Male","salary":5217},
{"id":2,"first_name":"Gary","last_name":"Vasentsov","email":"gvasentsov1@opensource.org","gender":"Male","salary":7368},
{"id":3,"first_name":"Betty","last_name":"Scothorne","email":"bscothorne2@eepurl.com","gender":"Female","salary":7303},
{"id":4,"first_name":"Cale","last_name":"Swettenham","email":"cswettenham3@bravesites.com","gender":"Male","salary":5488},
{"id":5,"first_name":"Luigi","last_name":"Olczak","email":"lolczak4@bluehost.com","gender":"Male","salary":6796},
{"id":6,"first_name":"Sisile","last_name":"Cammock","email":"scammock5@mapy.cz","gender":"Genderfluid","salary":3524},
{"id":7,"first_name":"Karoly","last_name":"McGinly","email":"kmcginly6@timesonline.co.uk","gender":"Female","salary":1534},
{"id":8,"first_name":"Noe","last_name":"Sidlow","email":"nsidlow7@woothemes.com","gender":"Male","salary":1542},
{"id":9,"first_name":"Emmery","last_name":"Harrema","email":"eharrema8@businessinsider.com","gender":"Male","salary":6260},
{"id":10,"first_name":"Kippie","last_name":"Baulcombe","email":"kbaulcombe9@gmpg.org","gender":"Male","salary":1687},
{"id":11,"first_name":"Viva","last_name":"Vannoort","email":"vvannoorta@xing.com","gender":"Genderfluid","salary":4136},
{"id":12,"first_name":"Aretha","last_name":"Blencoe","email":"ablencoeb@usa.gov","gender":"Bigender","salary":6065},
{"id":13,"first_name":"Hermia","last_name":"Georgeon","email":"hgeorgeonc@huffingtonpost.com","gender":"Female","salary":3157},
{"id":14,"first_name":"Jack","last_name":"Keynd","email":"jkeyndd@icio.us","gender":"Male","salary":4654},
{"id":15,"first_name":"Brynn","last_name":"Stanlick","email":"bstanlicke@sohu.com","gender":"Female","salary":6363},
{"id":16,"first_name":"Luelle","last_name":"Hawkin","email":"lhawkinf@wordpress.com","gender":"Female","salary":2765},
{"id":17,"first_name":"Ruy","last_name":"Abisetti","email":"rabisettig@sphinn.com","gender":"Male","salary":3198},
{"id":18,"first_name":"Gianna","last_name":"Pallas","email":"gpallash@psu.edu","gender":"Female","salary":5809},
{"id":19,"first_name":"Bel","last_name":"Treanor","email":"btreanori@nbcnews.com","gender":"Female","salary":9442},
{"id":20,"first_name":"Hammad","last_name":"Hegden","email":"hhegdenj@vinaora.com","gender":"Male","salary":2560}]`

let employees = JSON.parse(json);
console.log(employees);

document.querySelector('#searchGender').addEventListener('change', function(e){
initList();
})

function initList(){
let target = document.getElementById('empList');
target.innerHTML = '';
let selValue = document.querySelector('#searchGender').value
employees.forEach(emp => {
	if(selValue == 'All' || emp.gender == selValue)
	target.appendChild(makeRow(emp));
});
}
initList();

// 사원정보 => row 생성.
function makeRow(emp = {}) {
	let fields = ['id', 'first_name', 'last_name', 'salary'];
	let tr = document.createElement('tr');
	fields.forEach(field => {
		let td = document.createElement('td');
		td.innerHTML = emp[field];
		tr.appendChild(td);	
	})
	return tr;
}

