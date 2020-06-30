function namevalidation(idname, idmsg) {
    var n = document.getElementById(idname);
    var m = document.getElementById(idmsg);

    if (n.value.trim().length == 0) {
        m.innerHTML = "Invalid Name !";
        m.style.visibility = "visible";
        redcolor(idname);
        return false;
    }
    else {
        m.innerHTML = "";
        m.style.visibility = "Hidden";
        greencolor(idname);
        return true;
    }
}
function usernamevalidation(idname, idmsg) {
    var n = document.getElementById(idname);
    var m = document.getElementById(idmsg);

    if (n.value.trim().length == 0) {
        m.innerHTML = "Invalid Username !";
        m.style.visibility = "visible";
        redcolor(idname);
        return false;
    }
    else {
        m.innerHTML = "";
        m.style.visibility = "Hidden";
        greencolor(idname);
        return true;
    }
}
function passwordvalidation(idname, idmsg) {
    var p = document.getElementById(idname);
    var m = document.getElementById(idmsg);

    if (p.value.length < 6) {
        m.innerHTML = "Enter atleast 6 characters !";
        m.style.visibility = "visible";
        redcolor(idname);
        return false;
    }
    else if (p.length > 10) {
        m.innerHTML = "Maximum 10 Characters !";
        m.style.visibility = "visible";
        redcolor(idname);
        return false;
    }
    else {
        m.innerHTML = "";
        m.style.visibility = "Hidden";
        greencolor(idname);
        return true;
    }
}
function cpasswordvalidation(idname, idname2, idmsg) {
    var p = document.getElementById(idname);
    var cp = document.getElementById(idname2);
    var m = document.getElementById(idmsg);

    if (p.value == cp.value) {
        m.innerHTML = "";
        m.style.visibility = "Hidden";
        greencolor(idname2);
        return true;
    } else {
        m.innerHTML = "Password Not Match !";
        m.style.visibility = "visible";
        redcolor(idname2);
        return false;
    }
}
function registervalidate(idname, idmsg1, idusername, idmsg2, idpassword, idmsg3, idcpassword, idmsg4) {
    if (namevalidation(idname, idmsg1)) {
        if (usernamevalidation(idusername, idmsg2)) {
            if (passwordvalidation(idpassword, idmsg3)) {
                if (cpasswordvalidation(idpassword, idcpassword, idmsg4)) {
                    return true;
                }
            }
        }
    }
        
    return false;
}
function greencolor(str) {
    document.getElementById(str).style = "border: 2px solid green;";
}
function redcolor(str) {
    document.getElementById(str).style = "border: 2px solid red;";
}