async function addReimbursementFetch() {

    let url = "http://localhost:8080/Project1/reimbursements";

    let reimbursement = {

        employeeID: document.getElementById('employee_id').value,
        description: document.getElementById('description').value,
        eventType: document.getElementById('event_type').value,
        justification: document.getElementById('justification').value,
        reimbursementDate: document.getElementById('reimbursement_date').value,
        reimbursementTime: document.getElementById('reimbursement_time').value,
        employeeLocation: document.getElementById('employee_location').value,
        gradingFormat: document.getElementById('grading_format').value,
        reimbursementCost: document.getElementById('reimbursement_cost').value,
        passingGrade: document.getElementById('passing_grade').value,
        eventStart: document.getElementById('event_start').value,
        reimbursementName: document.getElementById('reimbursement_name').value
    }

    console.log(reimbursement);
    alert("Your Request has been Sent!");


    let res = await fetch(url, {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(reimbursement)
    });

    let resJson = await res.json()
    .then(res => {
        console.log(res);
    })
    .catch(error => {
        console.log(error);
    })



}



//
//function generateTableHead(table, data) {
//
//  var body = document.body,
//    tbl = document.createElement('table');
//  tbl.style.width = '100px';
//  tbl.style.border = '1px solid black';
//
//  var thead = table.createTHead();
//  var row = thead.insertRow();
//  for (let key of data) {
//    var th = document.createElement("th");
//    var text = document.createTextNode(key);
//    th.appendChild(text);
//    row.appendChild(th);
//  }
//  body.appendChild(tbl);
//
//
//}
function generateTable(data) {
  var body = document.body,
    tbl = document.createElement('table');
  tbl.style.width = '100px';
  tbl.style.border = '1px solid black';

//  header = tbl.insertRow();
//  let data1 = Object.keys(data[0]);
//
//  for (key in data1){
//    var td = header.insertCell();
//    td.appendChild(document.createTextNode(key));
//    td.style.border = '1px solid black';
//  }
  var row0 = tbl.insertRow();
  var record = data[0];
  for (key in record) {
    var th = row0.insertCell();
    th.appendChild(document.createTextNode(key));
    th.style.border = '2px solid black'
  }

  for (let element of data) {
    var row = tbl.insertRow();
    for (key in element) {

        var td = row.insertCell();
        td.appendChild(document.createTextNode(element[key]));
        console.log(`Key: ${key}, Value: ${element[key]}`);

        td.style.border = '1px solid black';

     }
   }
    body.appendChild(tbl);
}

function getRequests() {

    let url = 'http://localhost:8080/Project1/requests';

    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = receiveData;

    function receiveData() {

        if (this.readyState == 4) {
            let r = this.responseText;

            console.log(r);

            r = JSON.parse(r);
            generateTable(r);

            console.log(r);
        }
    }

    xhttp.open('GET', url, true);

    xhttp.send();

}

function showTuition(data){
    var body = document.body,
        tbl = document.createElement('table');
      tbl.style.width = '100px';
      tbl.style.border = '1px solid black';

    var row0 = tbl.insertRow();
    var th = row0.insertCell();
    th.appendChild(document.createTextNode("Tuition:"));
    var th1 = row0.insertCell();
    th1.appendChild(document.createTextNode(data));
    th.style.border = '2px solid black';
    th1.style.border = '2px solid black';
    body.appendChild(tbl);;
}

function getTuition(){
  let url = 'http://localhost:8080/Project1/employees';

    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = receiveData;

    function receiveData() {

        if (this.readyState == 4) {
            let r = this.responseText;

            console.log(r);
            r = JSON.parse(r);

            showTuition(r);
            console.log(r);
        }
    }

    xhttp.open('GET', url, true);

    xhttp.send();

}


function approveRequest1(){
    let url = 'http://localhost:8080/Project1/requests';

    let rID = document.getElementById('change_status').value;
    let bencoApproval = 'true';
     // and save into an object
    let request = {
        requestID: rID,
        employeeID: 0,
        reimbursementID: 0,
        status: "pending",
        supervisorApproval: "false",
        dptApproval: 'false',
        benCoApproval: 'true',
        urgent: 'false',
        deniedReason: '_'
    }

    console.log(request);
    alert("Request Has Been Approved!");

     // Now we can prepare and send our XMLHttpRequest Object
    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function () {

        if (this.readyState == 4 && this.status == 200) {
            let r = this.responseText;
            console.log(r);
        }

    }
    xhttp.open('PUT', 'http://localhost:8080/Project1/requests', true);

    // because we are sending data in the body, we need to tell our server what to expect
    xhttp.setRequestHeader('Content-Type', 'application/json');

    xhttp.send(JSON.stringify(request));
}

function denyRequest1(){
    let url = 'http://localhost:8080/Project1/requests';

    let rID = document.getElementById('change_status').value;
     // and save into an object
    let request = {
        requestID: rID,
        employeeID: 0,
        reimbursementID: 0,
        status: "denied",
        supervisorApproval: "false",
        dptApproval: 'false',
        benCoApproval: 'false',
        urgent: 'false',
        deniedReason: '_'
    }

    console.log(request);
    alert("Request Has Been Denied!");

     // Now we can prepare and send our XMLHttpRequest Object
    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function () {

        if (this.readyState == 4 && this.status == 200) {
            let r = this.responseText;
            console.log(r);
        }

    }
    xhttp.open('PUT', 'http://localhost:8080/Project1/requests', true);

    // because we are sending data in the body, we need to tell our server what to expect
    xhttp.setRequestHeader('Content-Type', 'application/json');

    xhttp.send(JSON.stringify(request));
}



function approveRequestDpt(){
    let url = 'http://localhost:8080/Project1/requests';

    let rID = document.getElementById('change_status').value;
    let bencoApproval = 'true';
     // and save into an object
    let request = {
        requestID: rID,
        employeeID: 0,
        reimbursementID: 0,
        status: "almost pending",
        supervisorApproval: "false",
        dptApproval: 'true',
        benCoApproval: 'false',
        urgent: 'false',
        deniedReason: '_'
    }

    console.log(request);
    alert("Request Has Been Approved!");

     // Now we can prepare and send our XMLHttpRequest Object
    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function () {

        if (this.readyState == 4 && this.status == 200) {
            let r = this.responseText;
            console.log(r);
        }

    }
    xhttp.open('PUT', 'http://localhost:8080/Project1/requests', true);

    // because we are sending data in the body, we need to tell our server what to expect
    xhttp.setRequestHeader('Content-Type', 'application/json');

    xhttp.send(JSON.stringify(request));
}

function denyRequestDpt(){
    let url = 'http://localhost:8080/Project1/requests';

    let rID = document.getElementById('change_status').value;
     // and save into an object
    let request = {
        requestID: rID,
        employeeID: 0,
        reimbursementID: 0,
        status: "denied",
        supervisorApproval: "false",
        dptApproval: 'false',
        benCoApproval: 'false',
        urgent: 'false',
        deniedReason: '_'
    }

    console.log(request);
    alert("Request Has Been Denied!");

     // Now we can prepare and send our XMLHttpRequest Object
    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function () {

        if (this.readyState == 4 && this.status == 200) {
            let r = this.responseText;
            console.log(r);
        }

    }
    xhttp.open('PUT', 'http://localhost:8080/Project1/requests', true);

    // because we are sending data in the body, we need to tell our server what to expect
    xhttp.setRequestHeader('Content-Type', 'application/json');

    xhttp.send(JSON.stringify(request));
}

function approveRequestSup(){
    let url = 'http://localhost:8080/Project1/requests';

    let rID = document.getElementById('change_status').value;

     // and save into an object
    let request = {
        requestID: rID,
        employeeID: 0,
        reimbursementID: 0,
        status: "almost pending",
        supervisorApproval: "true",
        dptApproval: 'false',
        benCoApproval: 'false',
        urgent: 'false',
        deniedReason: '_'
    }

    console.log(request);
    alert("Request Has Been Approved!");

     // Now we can prepare and send our XMLHttpRequest Object
    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function () {

        if (this.readyState == 4 && this.status == 200) {
            let r = this.responseText;
            console.log(r);
        }

    }
    xhttp.open('PUT', 'http://localhost:8080/Project1/requests', true);

    // because we are sending data in the body, we need to tell our server what to expect
    xhttp.setRequestHeader('Content-Type', 'application/json');

    xhttp.send(JSON.stringify(request));
}

function denyRequestSup(){
    let url = 'http://localhost:8080/Project1/requests';

    let rID = document.getElementById('change_status').value;
    let reason = document.getElementById('denied_reason').value;

     // and save into an object
    let request = {
        requestID: rID,
        employeeID: 0,
        reimbursementID: 0,
        status: "denied",
        supervisorApproval: "false",
        dptApproval: 'false',
        benCoApproval: 'false',
        urgent: 'false',
        deniedReason: reason
    }

    console.log(request);
    alert("Request Has Been Denied!");

     // Now we can prepare and send our XMLHttpRequest Object
    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function () {

        if (this.readyState == 4 && this.status == 200) {
            let r = this.responseText;
            console.log(r);
        }

    }
    xhttp.open('PUT', 'http://localhost:8080/Project1/requests', true);

    // because we are sending data in the body, we need to tell our server what to expect
    xhttp.setRequestHeader('Content-Type', 'application/json');

    xhttp.send(JSON.stringify(request));
}


function approveRequestBoth(){
    let url = 'http://localhost:8080/Project1/requests';

    let rID = document.getElementById('change_status').value;

    const cb = document.getElementById('supervisor');
    console.log(cb.checked);

    let sa = 'false';
    if (cb.checked){
        sa = 'true';
    }

     // and save into an object
    let request = {
        requestID: rID,
        employeeID: 0,
        reimbursementID: 0,
        status: "almost pending",
        supervisorApproval: sa,
        dptApproval: 'true',
        benCoApproval: 'false',
        urgent: 'false',
        deniedReason: '_'
    }

    console.log(request);
    alert("Request Has Been Approved!");

     // Now we can prepare and send our XMLHttpRequest Object
    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function () {

        if (this.readyState == 4 && this.status == 200) {
            let r = this.responseText;
            console.log(r);
        }

    }
    xhttp.open('PUT', 'http://localhost:8080/Project1/requests', true);

    // because we are sending data in the body, we need to tell our server what to expect
    xhttp.setRequestHeader('Content-Type', 'application/json');

    xhttp.send(JSON.stringify(request));
}

function denyRequestBoth(){
    let url = 'http://localhost:8080/Project1/requests';

    let rID = document.getElementById('change_status').value;
    let reason = document.getElementById('denied_reason').value;
     // and save into an object
    let request = {
        requestID: rID,
        employeeID: 0,
        reimbursementID: 0,
        status: "denied",
        supervisorApproval: "false",
        dptApproval: 'false',
        benCoApproval: 'false',
        urgent: 'false',
        deniedReason: reason
    }

    console.log(request);
    alert("Request Has Been Denied!");

     // Now we can prepare and send our XMLHttpRequest Object
    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function () {

        if (this.readyState == 4 && this.status == 200) {
            let r = this.responseText;
            console.log(r);
        }

    }
    xhttp.open('PUT', 'http://localhost:8080/Project1/requests', true);

    // because we are sending data in the body, we need to tell our server what to expect
    xhttp.setRequestHeader('Content-Type', 'application/json');

    xhttp.send(JSON.stringify(request));
}
function addGrade(){
    let url = 'http://localhost:8080/Project1/grades';

    let eID = document.getElementById('grade_employee_id').value;
    let rID = document.getElementById('grade_request_id').value;
    let pScore = document.getElementById('passing_score').value;
    let myScore = document.getElementById('my_grade').value;

     // and save into an object
    let grade = {
        employeeID: eID,
        requestID: rID,
        passingScore: pScore,
        score: myScore
    }

    console.log(grade);


     // Now we can prepare and send our XMLHttpRequest Object
    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function () {

        if (this.readyState == 4 && this.status == 200) {
            let r = this.responseText;
            console.log(r);
        }

    }
    xhttp.open('POST', 'http://localhost:8080/Project1/grades', true);

    // because we are sending data in the body, we need to tell our server what to expect
    xhttp.setRequestHeader('Content-Type', 'application/json');

    xhttp.send(JSON.stringify(grade));
}

function finalizeReimbursement(){
    let url = 'http://localhost:8080/Project1/employees';

    let rID = document.getElementById('request_id_approved').value;
    let eID = document.getElementById('employee_id_approved').value;
    let rAmount = document.getElementById('reimbursement_amount').value;


     // and save into an object
    let employee = {
        id: eID,
        firstName: '_',
        lastName: '_',
        username: '_',
        password: '_',
        department: '_',
        dptHead: 'false',
        supervisor: 'false',
        benCo: 'true',
        dptHeadId: 0,
        supervisorId: 0,
        benCoId: 0,
        tuitionLeft: rAmount
    }

    console.log(employee);

     // Now we can prepare and send our XMLHttpRequest Object
    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function () {

        if (this.readyState == 4 && this.status == 200) {
            let r = this.responseText;
            console.log(r);
        }

    }
    xhttp.open('PUT', 'http://localhost:8080/Project1/employees', true);

    // because we are sending data in the body, we need to tell our server what to expect
    xhttp.setRequestHeader('Content-Type', 'application/json');

    xhttp.send(JSON.stringify(employee));

    let request = {
        requestID: rID,
        employeeID: 0,
        reimbursementID: 0,
        status: "approved",
        supervisorApproval: 'true',
        dptApproval: 'true',
        benCoApproval: 'true',
        urgent: 'false',
        deniedReason: '_'
    }

    console.log(request);
    alert("Request Has Been Approved!");
            // Now we can prepare and send our XMLHttpRequest Object
    let xhttp1 = new XMLHttpRequest();

    xhttp1.onreadystatechange = function () {

        if (this.readyState == 4 && this.status == 200) {
            let r = this.responseText;
            console.log(r);
        }

    }
    xhttp1.open('PUT', 'http://localhost:8080/Project1/requests', true);

        // because we are sending data in the body, we need to tell our server what to expect
    xhttp1.setRequestHeader('Content-Type', 'application/json');
    xhttp1.send(JSON.stringify(request));


}



function goToHome()
{
    location.replace("home.html");
}

function goToBencoForm(){
    location.replace("bencoForm.html");
}
function goToDptForm(){
    location.replace("dptHeadForm.html");
}
function goToSupervisorForm(){
    location.replace("supervisorForm.html");
}
function goToBothForm(){
    location.replace("headAndSupervisor.html")
}



function moveToRequestTable()
{
    location.replace("requestsTable.html");
}

function moveToRequestTableBenco()
{
    location.replace("requestsTableBenco.html");
}

function moveToRequestTableDpt()
{
    location.replace("requestsTableDpt.html");
}
function moveToRequestTableSupervisor()
{
    location.replace("requestsTableSupervisor.html");
}
function moveToRequestTableBoth()
{
    location.replace("requestsTableBoth.html");
}




function moveToTuition()
{
    location.replace("tuition.html");
}
function moveToTuitionBenco()
{
    location.replace("tuitionBenco.html");
}
function moveToTuitionDpt()
{
    location.replace("tuitionDpt.html");
}
function moveToTuitionSupervisor()
{
    location.replace("tuitionSupervisor.html");
}
function moveToTuitionBoth()
{
    location.replace("tuitionBoth.html");
}


function logout() {
    location.replace("index2.html");
}