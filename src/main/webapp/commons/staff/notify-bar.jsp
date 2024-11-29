<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Notify sidebar -->
<div class="cr-notify-bar-overlay"></div>
<div class="cr-notify-bar">
    <div class="cr-bar-title">
        <h6>Notifications<span class="label">12</span></h6>
        <a href="javascript:void(0)" class="close-notify">
            <i class="ri-close-line"></i>
        </a>
    </div>
    <div class="cr-bar-content">
        <ul class="nav nav-tabs" id="myTab" role="tablist">
            <li class="nav-item" role="presentation">
                <button
                        class="nav-link active"
                        id="alert-tab"
                        data-bs-toggle="tab"
                        data-bs-target="#alert"
                        type="button"
                        role="tab"
                        aria-controls="alert"
                        aria-selected="true"
                >
                    Alert
                </button>
            </li>
        </ul>
        <div class="tab-content" id="myTabContent">
            <div
                    class="tab-pane fade show active"
                    id="alert"
                    role="tabpanel"
                    aria-labelledby="alert-tab"
            >
                <div class="cr-alert-list">
                    <ul>
                        <li>
                            <div class="icon cr-alert">
                                <i class="ri-alarm-warning-line"></i>
                            </div>
                            <div class="detail">
                                <div class="title">Đơn hàng mới</div>
                                <p class="time">Just now</p>
                                <p class="message">
                                    Please submit your quarterly report before - June 15.
                                </p>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>

        </div>
    </div>
</div>