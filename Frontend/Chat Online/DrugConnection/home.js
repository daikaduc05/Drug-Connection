// đã đọc thông báo
document.getElementById('dot-red').addEventListener('click', function () {
  var dotRed = this.querySelector('.dot-red');
  dotRed.classList.add('hidden');
});
// đề xuất follow
const followButtons = document.querySelectorAll('.follow');

followButtons.forEach(button => {
  button.addEventListener('click', function () {
    this.textContent = 'Followed';
    setTimeout(function () {
      button.parentNode.classList.add('hide');
      setTimeout(function () {
        button.parentNode.remove();
      }, 1000);
    }, 1000);
  });
});

// Lấy phần tử checkbox và số lượt likes
const checkbox = document.getElementById('Give-It-An-Id');
const likesSpan = document.querySelector('.num');

// Khởi tạo số lượt likes ban đầu
let likes = 0;

// Lắng nghe sự kiện click trên checkbox
checkbox.addEventListener('click', () => {
  // Nếu checkbox được chọn, tăng số lượt likes lên 1
  if (checkbox.checked) {
    likes++;
  }
  // Nếu checkbox không được chọn, giảm số lượt likes xuống 1
  else {
    likes--;
  }

  // Cập nhật số lượt likes trên giao diện
  likesSpan.textContent = `${likes} likes`;
});
// tăng số cmt

//bình luận
const addCommentButton = document.getElementById('addComment');
const commentsContainer = document.querySelector('.comments');
const commentTextarea = document.getElementById('commentTextarea');

addCommentButton.addEventListener('click', () => {
  const commentValue = commentTextarea.value.trim(); // Lấy giá trị và loại bỏ khoảng trắng thừa

  // check có cmt hay không
  if (commentValue === '') { // Kiểm tra nếu giá trị bình luận trống
    alert('Vui lòng nhập bình luận'); // Thông báo cho người dùng
    return; // Thoát khỏi hàm
  }

  const uniqueId = Date.now(); // Generate a unique ID for the new comment

  const newComment = `
    <div class="comment-react">
      <button id="likeButton-${uniqueId}">
        <svg fill="none" viewBox="0 0 24 24" height="16" width="16" xmlns="http://www.w3.org/2000/svg">
          <path fill="#707277" stroke-linecap="round" stroke-width="2" stroke="#707277"
            d="M19.4626 3.99415C16.7809 2.34923 14.4404 3.01211 13.0344 4.06801C12.4578 4.50096 12.1696 4.71743 12 4.71743C11.8304 4.71743 11.5422 4.50096 10.9656 4.06801C9.55962 3.01211 7.21909 2.34923 4.53744 3.99415C1.01807 6.15294 0.221721 13.2749 8.33953 19.2834C9.88572 20.4278 10.6588 21 12 21C13.3412 21 14.1143 20.4278 15.6605 19.2834C23.7783 13.2749 22.9819 6.15294 19.4626 3.99415Z">
          </path>
        </svg>
      </button>
      <hr>
      <span id="likeCount-${uniqueId}">0</span>
    </div>
    <div class="comment-container">
      <div class="user">
        <div class="user-pic">
          <a href="#"><img class="avatar" src="https://i.pinimg.com/236x/9d/4a/49/9d4a49b2b2b9392d3f844c4dbcff52d6.jpg" alt=""></a>
        </div>
        <div class="user-info">
          <span>hl_btoan</span>
          <p>1d</p>
        </div>
      </div>
      <div class="cmt-ct">
        <p class="comment-content">
          ${commentValue}
        </p>
      </div>
    </div>
  `;

  commentsContainer.insertAdjacentHTML('beforeend', newComment);

  // Scroll to the bottom of the comments container
  commentsContainer.scrollTop = commentsContainer.scrollHeight;

  // Clear the textarea
  commentTextarea.value = '';

  // Update the like button and like count
  const newLikeButton = document.getElementById(`likeButton-${uniqueId}`);
  const newLikeCount = document.getElementById(`likeCount-${uniqueId}`);
  let isLiked = false;

  newLikeButton.addEventListener('click', () => {
    isLiked = !isLiked;
    newLikeButton.classList.toggle('liked', isLiked);
    if (isLiked) {
      newLikeCount.textContent = parseInt(newLikeCount.textContent) + 1;
    } else {
      newLikeCount.textContent = Math.max(parseInt(newLikeCount.textContent) - 1, 0);
    }
  });
});
// start modal
// Thêm sự kiện click cho nút "Create"
document.getElementById('create').addEventListener('click', function () {
  const scrollTop = window.scrollY;
  const scrollLeft = window.scrollX;
  const modalTop = scrollTop + (window.innerHeight / 2);
  const modalLeft = scrollLeft + (window.innerWidth / 2);

  document.querySelector('.modal1').style.top = `${modalTop}px`;
  document.querySelector('.modal1').style.left = `${modalLeft}px`;

  document.querySelector('.layer1').classList.add('active');
  document.querySelector('.layer1').style.display = 'block';
  document.querySelector('.modal1').classList.add('active');
  document.body.style.overflow = 'hidden';
});

// Thêm sự kiện click cho nút "Close"
document.getElementById('close-button').addEventListener('click', function () {
  document.querySelector('.layer1').classList.remove('active');
  document.querySelector('.layer1').style.display = 'none';
  document.querySelector('.modal1').classList.remove('active');
  document.body.style.overflow = 'auto';
});

// Tùy chọn: Đóng modal khi click vào layer1
document.querySelector('.layer1').addEventListener('click', function () {
  document.querySelector('.layer1').classList.remove('active');
  document.querySelector('.layer1').style.display = 'none';
  document.querySelector('.modal1').classList.remove('active');
  document.body.style.overflow = 'auto';
});

// đăng ảnh
const fileInput = document.getElementById('file');
const upImgDiv = document.querySelector('.up-img');
const uploadButton = document.getElementById('upload-button');

fileInput.addEventListener('change', (e) => {
  const file = e.target.files[0];
  const reader = new FileReader();

  reader.onload = (event) => {
    const img = document.createElement('img');
    img.src = event.target.result;
    upImgDiv.innerHTML = '';
    upImgDiv.appendChild(img);
    uploadButton.style.display = 'block';
  };

  reader.readAsDataURL(file);
});

// đang mở modal không cuộn bài viết

document.getElementById('option-post').addEventListener('click', function() {
  document.querySelector('.layer1').style.display = 'block';
  document.querySelector('.modal2').style.display = 'block';
});

document.querySelector('.cancle').addEventListener('click', function() {
  document.querySelector('.layer1').style.display = 'none';
  document.querySelector('.modal2').style.display = 'none';
});

document.querySelector('.layer1').addEventListener('click', function() {
  document.querySelector('.layer1').style.display = 'none';
  document.querySelector('.modal2').style.display = 'none';
});