<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Review Section -->
<section class="review-section">
  <h1>Đánh giá sản phẩm</h1>

  <div class="product-display">
    <div class="product-image">
      <img src="customer\img\review\1.jpg" alt="Tên sách và tác giả" />
    </div>

    <div class="product-info">
      <p><strong>Tên Sách: Sức Mạnh Của Thói Quen</strong></p>
      <p>Tác giả: Charles Duhigg</p>
      <p>Phân loại: Bìa mềm, Phiên bản tiếng Việt</p>
    </div>
  </div>

  <div class="rating">
    <label>Chất lượng sản phẩm</label>
    <div class="star-rating">
      <input type="radio" id="5-stars" name="rating" value="5" />
      <label for="5-stars" class="star">★</label>
      <input type="radio" id="4-stars" name="rating" value="4" />
      <label for="4-stars" class="star">★</label>
      <input type="radio" id="3-stars" name="rating" value="3" />
      <label for="3-stars" class="star">★</label>
      <input type="radio" id="2-stars" name="rating" value="2" />
      <label for="2-stars" class="star">★</label>
      <input type="radio" id="1-star" name="rating" value="1" />
      <label for="1-star" class="star">★</label>
    </div>
    <span class="rating-text">Chọn sao để đánh giá</span>
  </div>

  <div class="upload-wrapper">
    <label for="upload-image" class="upload-label"
    >Thêm Hình ảnh/Video:</label
    >
    <div class="upload-section">
      <button class="upload-btn" id="upload-image-btn">
        <span class="icon-camera"></span>
        <span class="btn-text">Thêm Hình ảnh</span>
      </button>
      <input
              type="file"
              id="upload-image"
              accept="image/*"
              style="display: none"
              multiple
      />

      <button class="upload-btn" id="upload-video-btn">
        <span class="icon-video"></span>
        <span class="btn-text">Thêm Video</span>
      </button>
      <input
              type="file"
              id="upload-video"
              accept="video/*"
              style="display: none"
      />
    </div>
    <p class="upload-hint">Tối đa 9 hình ảnh hoặc video</p>
  </div>

  <div class="review-input">
        <textarea
                placeholder="Hãy chia sẻ cảm nhận về sản phẩm này bạn nhé!"
        ></textarea>
  </div>

  <div class="display-name">
    <label for="ten-dang-nhap"
    >Bạn sẽ giới thiệu cuốn sách này tới mọi người chứ?</label
    >
    <input type="checkbox" id="ten-dang-nhap" checked />
  </div>

  <div class="submit-review">
    <button class="submit-btn">Gửi Đánh Giá</button>
  </div>
</section>
