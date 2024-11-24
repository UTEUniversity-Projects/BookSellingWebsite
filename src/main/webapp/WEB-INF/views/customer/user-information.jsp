<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/customer/scss/style.css">


<section class="section-profile padding-tb-100">
    <div class="container-md">
        <div class="row justify-center">
            <div class="col-sm-8 col-md-12">
                <div class="profile-card" data-aos="fade-up" data-aos-duration="2000" data-aos-delay="400">
                    <!-- Logo ở trên -->
                    <div class="logo-container">
                        <img src="${pageContext.request.contextPath}/assets/customer/img/logo/biblio.png" alt="logo"
                             class="logo"/>
                    </div>

                    <div class="row">
                        <!-- Phần bên trái: Avatar, Tên, Giới tính, Membership -->
                        <div class="col-md-4">
                            <div class="left-section">
                                <div class="avatar-container">
                                    <img src="${customer.avatar}" alt="avatar" class="avatar"/>
                                </div>
                                <div class="user-info">
                                    <h3 class="name">${customer.fullName}</h3>
                                    <p class="gender">Giới tính: ${customer.gender}</p>
                                    <p class="membership">Membership: ${customer.memberShip}</p>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-8">
                            <form action="#" class="profile-form">
                                <div class="row">
                                    <div class="col-sm-12 col-md-6">
                                        <div class="form-group mb-2">
                                            <label class="label">Email*</label>
                                            <input type="email" value="${customer.email}" readonly
                                                   class="form-control pointer-events-none"/>
                                        </div>
                                    </div>
                                    <div class="col-sm-12 col-md-6">
                                        <div class="form-group mb-2">
                                            <label class="label">Tên đăng nhập*</label>
                                            <input type="text" value="${customer.username}" readonly
                                                   class="form-control pointer-events-none"/>
                                        </div>
                                    </div>

                                    <!-- Số điện thoại và Ngày sinh -->
                                    <div class="col-sm-12 col-md-6">
                                        <div class="form-group mb-2">
                                            <label class="label">Số điện thoại*</label>
                                            <input type="tel" value="${customer.phoneNumber}" readonly
                                                   class="form-control pointer-events-none"/>
                                        </div>
                                    </div>
                                    <div class="col-sm-12 col-md-6">
                                        <div class="form-group mb-2">
                                            <label class="label">Ngày sinh</label>
                                            <input type="date" value="${customer.dateOfBirth}" readonly
                                                   class="form-control pointer-events-none"/>
                                        </div>
                                    </div>

                                    <!-- Địa chỉ -->
                                    <div class="col-sm-12 col-md-12">
                                        <div class="form-group mb-2">
                                            <p class="font-bold text-xl">Địa chỉ</p>
                                            <ul>
                                                <c:forEach items="${customer.addresses}" var="o">
                                                    <li>
                                                        <p>
                                                            - ${o.detail}, ${o.village}, ${o.district}, ${o.province}, ${o.nation}.</p>
                                                    </li>
                                                </c:forEach>
                                            </ul>
                                        </div>
                                    </div>
                                    <%--                                    <div class="col-sm-12 col-md-6">--%>
                                    <%--                                        <div class="form-group mb-2">--%>
                                    <%--                                            <label class="label">Quận Huyện</label>--%>
                                    <%--                                            <input type="text" value="Ba Đình" readonly class="form-control"/>--%>
                                    <%--                                        </div>--%>
                                    <%--                                    </div>--%>
                                    <%--                                    <div class="col-sm-12 col-md-6">--%>
                                    <%--                                        <div class="form-group mb-2">--%>
                                    <%--                                            <label class="label">Phường Xã</label>--%>
                                    <%--                                            <input type="text" value="Phường Kim Mã" readonly class="form-control"/>--%>
                                    <%--                                        </div>--%>
                                    <%--                                    </div>--%>
                                    <%--                                    <div class="col-sm-12 col-md-6">--%>
                                    <%--                                        <div class="form-group mb-2">--%>
                                    <%--                                            <label class="label">Số nhà | Ấp | Tổ</label>--%>
                                    <%--                                            <input type="text" value="Số 10, Ngõ 123" readonly class="form-control"/>--%>
                                    <%--                                        </div>--%>
                                    <%--                                    </div>--%>
                                </div>

                                <div class="button-container mt-3">
                                    <div class="button-group">
                                        <a href="#" class="change-password-button">Đổi mật khẩu</a>
                                        <a href="${pageContext.request.contextPath}/update-information"
                                           class="update-button">Cập nhật thông tin</a>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
