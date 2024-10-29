<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- main content -->
<div class="cr-main-content">
  <div class="container-fluid">
    <!-- Page title & breadcrumb -->
    <div class="cr-page-title cr-page-title-2">
      <div class="cr-breadcrumb">
        <h5>Thông tin khách hàng</h5>
        <ul>
          <li><a href="index.html">Biblio</a></li>
          <li>Thông tin khách hàng</li>
        </ul>
      </div>
    </div>
    <div class="row">
      <div class="col-xl-3 col-lg-12">
        <div class="vendor-sticky-bar">
          <div class="col-xl-12">
            <div class="cr-card">
              <div class="cr-card-content">
                <div class="cr-vendor-block-img">
                  <div class="cr-vendor-block-detail">
                    <div class="profile-img">
                      <div class="avatar-previews">
                        <div class="avatar-customer-img" id="avatar-customer-edit"
                             style="background-image: url(/assets/owner/img/clients/3.jpg); background-position: center;">
                          <i class="ri-image-edit-line edit-icon" id="edit-avatar" style="display: none;"></i>
                        </div>
                      </div>
                      <input type="file" id="avatarUpload" style="display: none;" accept="image/*" disable>
                    </div>
                    <h5 class="name">Name</h5>
                    <div class="cr-settings">
                      <a href="" class="cr-btn-primary m-r-10" id="edit-button">Chỉnh sửa</a>
                    </div>
                  </div>
                  <div class="cr-vendor-info">
                    <ul>
                      <li>
                        <label>Tên :</label>
                        <div class="form-group p-b-15">
                          <input type="text" class="form-control" id="name-customer-edit"
                                 value="Elizabeth Morgus" disabled>
                        </div>
                      </li>
                      <li>
                        <label>Email :</label>
                        <div class="form-group p-b-15">
                          <input type="text" class="form-control" id="email-customer-edit"
                                 value="name@gmial.com" disabled>
                        </div>
                      </li>
                      <li>
                        <label>Điện thoại :</label>
                        <div class="form-group p-b-15">
                          <input type="text" class="form-control" id="phone-customer-edit"
                                 value="www.example.com" disabled>
                        </div>
                      </li>
                      <li>
                        <label>Quốc gia :</label>
                        <div class="form-group">
                          <div class="select-oject-customer">
                            <select class="select-item" id="select-nation" disabled>
                              <option selected disabled> - Chọn - </option>
                              <option value="1">Việt Nam</option>
                              <option value="2">Mỹ</option>
                            </select>
                          </div>
                        </div>
                      </li>
                      <li>
                        <label>Ngày tham gia :</label>
                        <div class="form-group p-b-15">
                          <input type="text" class="form-control"
                                 value="09/13/2023" disabled>
                        </div>
                      </li>
                    </ul>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="col-xl-9 col-lg-12">
        <div class="cr-card vendor-profile">
          <div class="cr-card-content vendor-details mb-m-30">
            <div class="row cr-vendor-info details">
              <div class="col-sm-12">
                <h3>Thông tin chi tiết</h3>
              </div>
              <div class="col-md-6 col-sm-12">
                <div class="form-group">
                  <label>Ngày sinh</label>
                  <div class="col-12">
                    <input type="text" id="birthday-customer-edit" name="birthday" value="01/18/2004" style="width: 100%;" disabled>
                  </div>
                </div>
              </div>
              <div class="col-md-6 col-sm-12">
                <div class="form-group">
                  <label>Giới tính</label>
                  <div class="select-oject-customer">
                    <select class="select-item" id="select-gender" disabled>
                      <option selected disabled> - Chọn - </option>
                      <option value="1">Nam</option>
                      <option value="2">Nữ</option>
                    </select>
                  </div>
                </div>
              </div>
              <div class="col-md-4 col-sm-12">
                <div class="form-group">
                  <label>Tỉnh</label>
                  <div class="select-oject-customer">
                    <select class="select-item" id="select-province" disabled>
                      <option selected disabled> - Chọn - </option>
                      <option value="1">Việt Nam</option>
                      <option value="2">Mỹ</option>
                    </select>
                  </div>
                </div>
              </div>
              <div class="col-md-4 col-sm-12">
                <div class="form-group">
                  <label>Quận / Huyện</label>
                  <div class="select-oject-customer">
                    <select class="select-item" id="select-district" disabled>
                      <option selected disabled> - Chọn - </option>
                      <option value="1">Việt Nam</option>
                      <option value="2">Mỹ</option>
                    </select>
                  </div>
                </div>
              </div>
              <div class="col-md-4 col-sm-12">
                <div class="form-group">
                  <label>Phường / Xã</label>
                  <div class="select-oject-customer">
                    <select class="select-item" id="select-villiage">
                      <option selected disabled> - Chọn - </option>
                      <option value="1">Việt Nam</option>
                      <option value="2">Mỹ</option>
                    </select>
                  </div>
                </div>
              </div>
              <div class="col-md-12 col-sm-12">
                <div class="form-group">
                  <label>Địa chỉ cụ thể</label>
                  <div class="col-12">
                    <input name="text" id="address-customer-edit" class="form-control here slug-title" type="text" value="01 Đ. Võ Văn Ngân, Linh Chiểu, Thủ Đức, Hồ Chí Minh" disabled>
                  </div>
                </div>
              </div>
              <div class="col-md-6 col-sm-12 ">
                <div class="form-group">
                  <label>Tên đăng nhập</label>
                  <div class="col-12">
                    <input id="username-customer-edit"
                           class="form-control here slug-title" type="text" value="abcd@1234" disabled>
                  </div>
                </div>
              </div>
              <div class="col-md-6 col-sm-12 ">
                <div class="form-group">
                  <label>Mật khẩu</label>
                  <div class="col-12">
                    <input id="password-customer-edit"
                           class="form-control here slug-title" type="text" value="abcd@1234" disabled>
                  </div>
                </div>
              </div>
              <div class="col-md-6 col-sm-12 ">
                <div class="form-group">
                  <label>Số đơn hàng đã mua</label>
                  <div class="col-12">
                    <input id="count-order-customer-edit"
                           class="form-control here slug-title" type="text" value="53" disabled>
                  </div>
                </div>
              </div>
              <div class="col-md-6 col-sm-12 ">
                <div class="form-group">
                  <label>Số tiền đã chi</label>
                  <div class="col-12">
                    <input id="cost-customer-edit"
                           class="form-control here slug-title" type="text" value="13 000 444 vnđ" disabled>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
