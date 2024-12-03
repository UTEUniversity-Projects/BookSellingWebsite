<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<section class="container-xl mx-auto">
  <div class="mt-[50px]">
    <c:forEach var="notification" items="${notificationGetResponse}">
      <div class="flex items-center justify-between mb-4">
        <div class="w-[200px] h-[200px] flex-shrink-0">
          <img
                  src="https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lwxpv4ydgxjt57.webp"
                  alt=""
                  class="w-full h-full object-cover"
          />
        </div>
        <div class="basis-2/3">
          <h4 class="text-black font-bold text-xl">${notification.title}</h4>
          <p class="text-[16px]">${notification.content}</p>
          <p class="text-sm">${notification.sentTime}</p>
        </div>

        <a href="${pageContext.request.contextPath}${notification.hyperLink}"
           class="px-4 py-2 bg-gray-200 notification-detail-link"
           data-id="${notification.id}">
          Xem chi tiết
        </a>
      </div>
    </c:forEach>
  </div>
</section>


<script>
  $(document).ready(function() {
    // Lắng nghe sự kiện click vào nút "Xem chi tiết"
    $(".notification-detail-link").click(function() {
      const notificationId = $(this).data("id");

      $.ajax({
        url: `${pageContext.request.contextPath}/api/customer/notification/update`,
        type: 'POST',
        data: { notificationId: notificationId },
        success: function(response) {
        },
        error: function(error) {
        }
      });
    });
  });
</script>