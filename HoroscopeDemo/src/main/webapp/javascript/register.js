let submitButton = document.getElementById("register-button");
submitButton.addEventListener("click", (event) => {
event.preventDefault();
    //do AJAX
    //1. Create the XMLHttpRequest obj
    let xhttp = new XMLHttpRequest();
    // //next were going to get the values from the form
//    let user_id = document.getElementByID("user_id").value;
    let firstname = document.getElementById("first_name-input").value;
    let lastname = document.getElementById("last_name-input").value;
    let username = document.getElementById("user_name-input");
    let email = document.getElementById("email-input").value;
    let password = document.getElementById("password-input").value;
    let zodiac = document.getElementById("zodiac-input").value;

    let registerbutton = {
        first_name:firstname,
        last_name: lastname,
        username: username,
        email: email,
        password:password,
        zodiac:zodiac,
    }
    console.log(register-button);


        xhttp.onreadystatechange = function(){
            //200 status code is a OK response
       //which means that everything was processed correctly
       if(this.readyState == 4 && xhttp.status == 200){
        console.log(xhttp.responseText);
        let data = JSON.parse(xhttp.responseText);
         console.log(data);
         //global caching function
        // localStorage.setItem('register', JSON.stringify(data));
        window.location.replace("welcome.html")
        } else if(this.readyState == 4 && xhttp.status ===204) {
            console.log(xhttp.responseText)
            console.log()
                alert("Failed. Status Code: " + xhttp.status)
        }
    };
    //STEP 3: OPEN THE REQUEST
    xhttp.open("POST",`http://localhost:8080/HoroscopeDemo/register`)
    xhttp.setRequestHeader("Content-Type", "application/json");
    xhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
     console.log(xhttp);
    //STEP 4- send the request
    xhttp.send(JSON.stringify(register-button));
});
// function renderHTML(data){
//     // let resp = document.getElementById("input");
//     // //append all response data to my webpage
//     // resp.append("Name: " + data.name);
//     // resp.append(document.createElement('br'));
//     // resp.append("ID: " + data.id);
//     // resp.append(document.createElement('br'));
//     console.log(data.email);
//     console.log(data.last_name);
//     // window.location.replace("tickets.html")
//     }