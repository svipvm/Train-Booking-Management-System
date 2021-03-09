function modifyCheck() {
    var uname = document.getElementById("uname");
    var uidcard = document.getElementById("uidcard");
    var uphone = document.getElementById("uphone");
    var modifypwd = document.getElementById("modifypwd");
    var password = document.getElementById("password");
    var reg1 = new RegExp(/^[a-zA-Z0-9]{6,20}$/);
    var reg2 = new RegExp(/^\d{17}(\d|X|x)$/);

    if(password.value === "") {
        alert("请输入原始密码！");
        password.focus();
        return false;
    }

    if(uname.value !== "" && !reg1.test(uname.value)) {
        alert("用户名不规范，请输入6~20位的数字或字母！");
        uname.focus();
        return false;
    }
    if(uidcard.value !== "" && !reg2.test(uidcard.value)) {
        alert("请正确输入您的身份证！");
        uidcard.focus();
        return false;
    }
    reg2 = new RegExp(/^[a-zA-Z0-9]{6,20}$/);
    if(uphone.value !== "" && !reg2.test(uphone.value)) {
        alert("手机号不规范，请输入11位的数字！");
        uphone.focus();
        return false;
    }
    if(modifypwd.value !== "" && !reg1.test(modifypwd.value)) {
        alert("修改密码不规范，请输入6~20位的数字或字母！");
        modifypwd.focus();
        return false;
    }

    return true;
}

function loginCheck() {
    var account = document.getElementById("account");
    var password = document.getElementById("password");

    if(account.value === "") {
        alert("请输入账号！");
        account.focus();
        return false;
    }
    if(password.value === "") {
        alert("请输入密码！");
        password.focus();
        return false;
    }
}

function registerCheck() {
    var account = document.getElementById("account");
    var password = document.getElementById("password");
    var repwd = document.getElementById("repwd");
    var uidcard = document.getElementById("uidcard");
    var uphone = document.getElementById("uphone");

    if(account.value === "") {
        alert("请输入账号！");
        account.focus();
        return false;
    }
    if(password.value === "") {
        alert("请输入密码！");
        password.focus();
        return false;
    }
    if(repwd.value === "") {
        alert("请输入确认密码！");
        repwd.focus();
        return false;
    }
    if(uidcard.value === "") {
        alert("请输入身份证号！");
        uidcard.focus();
        return false;
    }
    if(uphone.value === "") {
        alert("请输入手机号！");
        uphone.focus();
        return false;
    }

    var reg = new RegExp(/^[a-zA-Z0-9]{6,20}$/);
    if(!reg.test(account.value)) {
        alert("账号不规范，请输入6~20位的数字或字母！");
        account.focus();
        return false;
    }
    if(!reg.test(password.value)) {
        alert("密码不规范，请输入6~20位的数字或字母！");
        password.focus();
        return false;
    }
    reg = new RegExp(/^\d{17}(\d|X|x)$/);
    if(!reg.test(uidcard.value)) {
        alert("请正确输入您的身份证！");
        uidcard.focus();
        return false;
    }
    reg = new RegExp(/^[1][0-9]{10}$/);
    if(!reg.test(uphone.value)) {
        alert("手机号不规范，请输入11位的数字！");
        uphone.focus();
        return false;
    }

    if(password.value === repwd.value) {
        return true;
    } else {
        alert("两次密码不一致，请重新输入！");
        return false;
    }
}

