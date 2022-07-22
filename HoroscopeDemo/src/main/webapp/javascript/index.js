let loginButton = document.getElementById("login-button");

console.log(loginButton);

loginButton.addEventListener("click", (event) =>{

event.preventDefault(); //this prevents the default behavior

// do out Ajax call
//1. create our XMLHttpRequest obj

let xhttp = new XMLHttpRequest();

//next we are goin to get the values from our form

let email = document.getElementById("email-sign-in").value;

let password = document.getElementById("password-sign-in").value;

//here we are creating a "loginInfo" object
let loginButton = {
    email:email,
    password: password,

    //last_name can be password
}

console.log(loginButton)

//STEP 2: Define the behaviors of our responses as they come back from the server
    /*
        A readyState is a property which signifies that state that the request is currently in.
        There are several states:
        0: UNSENT - opening of the request has yet to be called
        1: OPENED - open() has been called
        2: HEADERS_RECEIVED: send() has been called[aka the request has been sent], and the headers of the response as well as the status are now available.
        3: LOADING: downloading the response. Therefore, the responseText (which is a xhr property) is holding partial data.
        4: DONE: the entire operation is now complete
        Why need readyStates?
        Often you can implement other transitions or animations to your webpages by triggering them at given readyStates.
        ex. loading screens
    */


        xhttp.onreadystatechange = function(){

            //200 status is OK
            //means that everything was processed correctly

            if(this.readyState == 4 && xhttp.status === 200){

                console.log(xhttp.responseText);

                let data = JSON.parse(xhttp.responseText);
                console.log(data); 

                //global caching

                localStorage.setItem(`register`, JSON.stringify(data));
                window.location.replace("register.html")

            }else if (this.readyState == 4 && xhttp.status == 204){
                console.log(xhttp.responseText)
                alert("Failed to login: Status code -" + xhttp.status)
            }




        };

        //Step 3 : OPEN THE REQUEST

        xhttp.open("POST", `http://localhost:8080/HoroscopeDemo/user`)

        xhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
        xhttp.setRequestHeader("Content-Type","application/json");

       console.log(xhttp)

        //step 4- send status
        xhttp.send(JSON.stringify(loginButton))








});