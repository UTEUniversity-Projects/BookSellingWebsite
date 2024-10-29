import { getAddress, register } from './register.js';
import { login } from './login.js';
import { verifyEmail } from "./verify-email.js";
import { forgotPassword } from "./forgot-password.js";
import { countNotifications } from "./view-notifications.js";
import { updateInformation } from "./update-information.js";

$(document).ready(() => {
	register();
	login();
	getAddress();
	verifyEmail();
	forgotPassword();
	countNotifications();
	updateInformation();
}
