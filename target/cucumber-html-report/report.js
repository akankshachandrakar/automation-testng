$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Login.feature");
formatter.feature({
  "line": 1,
  "name": "login in gurru website",
  "description": "",
  "id": "login-in-gurru-website",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 2,
  "name": "login with correct username and password",
  "description": "",
  "id": "login-in-gurru-website;login-with-correct-username-and-password",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 3,
  "name": "I am on login page",
  "keyword": "Given "
});
formatter.step({
  "line": 4,
  "name": "I enter username and password",
  "keyword": "When "
});
formatter.step({
  "line": 5,
  "name": "I click on sumbit button",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "homepage should be displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginSteps.i_am_on_login_page()"
});
formatter.result({
  "duration": 292937178,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.i_enter_username_and_password()"
});
formatter.result({
  "duration": 92977,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.i_click_on_sumbit_button()"
});
formatter.result({
  "duration": 304289,
  "status": "passed"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});