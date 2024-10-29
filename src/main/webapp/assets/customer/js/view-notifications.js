export function countNotifications() {
	$(".notification-count").text($(".notification-body").children().length);
}