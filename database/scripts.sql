-- Dữ liệu ảo
-- USE `bsw-biblio`;
-- 1. Table Account:
INSERT INTO account (password, status, role, username) VALUES
('abc', 'ACTIVE', 'OWNER', 'owner_1'),
('abc', 'ACTIVE', 'STAFF', 'staff_1'),
('abc', 'ACTIVE', 'STAFF', 'staff_2'),
('abc', 'ACTIVE', 'CUSTOMER', 'customer_1'),
('abc', 'ACTIVE', 'CUSTOMER', 'customer_2'),
('abc', 'ACTIVE', 'CUSTOMER', 'customer_3'),
('abc', 'ACTIVE', 'CUSTOMER', 'customer_4'),
('abc', 'ACTIVE', 'CUSTOMER', 'customer_5'),
('abc', 'ACTIVE', 'CUSTOMER', 'customer_6'),
('abc', 'ACTIVE', 'CUSTOMER', 'customer_7'),
('abc', 'ACTIVE', 'CUSTOMER', 'customer_8'),
('abc', 'ACTIVE', 'CUSTOMER', 'customer_9'),
('abc', 'ACTIVE', 'CUSTOMER', 'customer_10'),
('abc', 'ACTIVE', 'CUSTOMER', 'customer_11'),
('abc', 'ACTIVE', 'CUSTOMER', 'customer_12'),
('abc', 'ACTIVE', 'CUSTOMER', 'customer_13'),
('abc', 'ACTIVE', 'CUSTOMER', 'customer_14'),
('abc', 'ACTIVE', 'CUSTOMER', 'customer_15');

-- 2. Table Owner:customer_notificationnotification
INSERT INTO owner (avatar, date_of_birth, email_address, full_name, gender, join_at, phone_number, account_id)
VALUES 
('https://kenh14cdn.com/203336854389633024/2022/4/9/1732920193150637133093626329146106221360649n-164947443607057196887.jpeg', '1985-07-15', 'owner_1@gmail.com', 'Nguyễn Văn An', 'MALE', '2023-03-15', '0123456789', 1);

-- 3. Table Staff:
INSERT INTO staff (avatar, date_of_birth, email_address, full_name, gender, join_at, phone_number, account_id)
VALUES 
('https://kenh14cdn.com/203336854389633024/2022/4/9/1732920193150637133093626329146106221360649n-164947443607057196887.jpeg', '1990-05-20', 'staff_1@gmail.com', 'Trần Minh Hoàng', 'MALE', '2022-08-12', '0987654321', 2),
('https://kenh14cdn.com/203336854389633024/2022/4/9/1732920193150637133093626329146106221360649n-164947443607057196887.jpeg', '1992-09-14', 'staff_2@gmail.com', 'Nguyễn Ngọc Anh', 'FEMALE', '2023-04-20', '0912345678', 3);
-- 4. Table Customer:
INSERT INTO customer (avatar, date_of_birth, email_address, full_name, gender, join_at, phone_number, membership, account_id)
VALUES 
('https://kenh14cdn.com/203336854389633024/2022/4/9/1732920193150637133093626329146106221360649n-164947443607057196887.jpeg', '1990-04-10', 'customer_1@gmail.com', 'Lê Văn Hùng', 'MALE', '2022-05-15', '0901234561', 'GOLD', 4),
('https://kenh14cdn.com/203336854389633024/2022/4/9/1732920193150637133093626329146106221360649n-164947443607057196887.jpeg', '1991-06-12', 'customer_2@gmail.com', 'Nguyễn Thị Lan', 'FEMALE', '2023-03-10', '0901234562', 'GOLD', 5),
('https://kenh14cdn.com/203336854389633024/2022/4/9/1732920193150637133093626329146106221360649n-164947443607057196887.jpeg', '1992-09-20', 'customer_3@gmail.com', 'Phạm Minh Tuấn', 'MALE', '2022-12-01', '0901234563', 'GOLD', 6),
('https://kenh14cdn.com/203336854389633024/2022/4/9/1732920193150637133093626329146106221360649n-164947443607057196887.jpeg', '1993-11-11', 'customer_4@gmail.com', 'Trần Thị Hồng', 'FEMALE', '2023-07-15', '0901234564', 'GOLD', 7),
('https://kenh14cdn.com/203336854389633024/2022/4/9/1732920193150637133093626329146106221360649n-164947443607057196887.jpeg', '1989-03-18', 'customer_5@gmail.com', 'Đỗ Quang Khải', 'MALE', '2022-06-20', '0901234565', 'GOLD', 8),
('https://kenh14cdn.com/203336854389633024/2022/4/9/1732920193150637133093626329146106221360649n-164947443607057196887.jpeg', '1994-05-09', 'customer_6@gmail.com', 'Vũ Thanh Tùng', 'MALE', '2023-08-05', '0901234566', 'GOLD', 9),
('https://kenh14cdn.com/203336854389633024/2022/4/9/1732920193150637133093626329146106221360649n-164947443607057196887.jpeg', '1990-07-15', 'customer_7@gmail.com', 'Bùi Thị Mai', 'FEMALE', '2022-10-10', '0901234567', 'GOLD', 10),
('https://kenh14cdn.com/203336854389633024/2022/4/9/1732920193150637133093626329146106221360649n-164947443607057196887.jpeg', '1995-08-21', 'customer_8@gmail.com', 'Lê Ngọc Thanh', 'MALE', '2023-01-22', '0901234568', 'GOLD', 11),
('https://kenh14cdn.com/203336854389633024/2022/4/9/1732920193150637133093626329146106221360649n-164947443607057196887.jpeg', '1991-04-11', 'customer_9@gmail.com', 'Phan Hữu Nam', 'MALE', '2022-11-10', '0901234569', 'GOLD', 12),
('https://kenh14cdn.com/203336854389633024/2022/4/9/1732920193150637133093626329146106221360649n-164947443607057196887.jpeg', '1992-12-17', 'customer_10@gmail.com', 'Trịnh Quang Minh', 'MALE', '2023-04-14', '0901234570', 'GOLD', 13),
('https://kenh14cdn.com/203336854389633024/2022/4/9/1732920193150637133093626329146106221360649n-164947443607057196887.jpeg', '1988-02-27', 'customer_11@gmail.com', 'Nguyễn Anh Tuấn', 'MALE', '2022-09-18', '0901234571', 'GOLD', 14),
('https://kenh14cdn.com/203336854389633024/2022/4/9/1732920193150637133093626329146106221360649n-164947443607057196887.jpeg', '1990-10-30', 'customer_12@gmail.com', 'Đặng Thị Thanh', 'FEMALE', '2023-05-19', '0901234572', 'GOLD', 15),
('https://kenh14cdn.com/203336854389633024/2022/4/9/1732920193150637133093626329146106221360649n-164947443607057196887.jpeg', '1987-01-25', 'customer_13@gmail.com', 'Võ Minh Châu', 'FEMALE', '2022-12-21', '0901234573', 'GOLD', 16),
('https://kenh14cdn.com/203336854389633024/2022/4/9/1732920193150637133093626329146106221360649n-164947443607057196887.jpeg', '1993-09-19', 'customer_14@gmail.com', 'Hoàng Văn Nam', 'MALE', '2023-02-16', '0901234574', 'GOLD', 17),
('https://kenh14cdn.com/203336854389633024/2022/4/9/1732920193150637133093626329146106221360649n-164947443607057196887.jpeg', '1989-03-16', 'customer_15@gmail.com', 'Trần Thị Bích', 'FEMALE', '2023-06-05', '0901234575', 'GOLD', 18);

-- 5. Table Category:
INSERT INTO category (full_script, name, short_script, status) VALUES 
('Các thể loại: Tiểu thuyết, Văn học cổ điển, Văn học hiện đại, Tác phẩm nổi tiếng.', 'Tiểu thuyết & Văn học', 'Sách về tiểu thuyết và văn học.', 'ACTIVE'),
('Các thể loại: Truyện cổ tích, Truyện tranh, Tiểu thuyết thiếu nhi, Hướng dẫn phát triển ngôn ngữ cho trẻ.', 'Sách thiếu nhi', 'Sách dành cho thiếu nhi.', 'ACTIVE'),
('Các thể loại: Kinh tế học, Quản trị kinh doanh, Đầu tư, Tài chính cá nhân, Kinh tế vĩ mô.', 'Sách kinh tế', 'Sách về các lĩnh vực kinh tế.', 'ACTIVE'),
('Các thể loại: Kỹ năng giao tiếp, Kỹ năng quản lý thời gian, Kỹ năng lãnh đạo, Kỹ năng làm việc nhóm.', 'Sách kỹ năng sống', 'Sách giúp phát triển kỹ năng sống và tự hoàn thiện bản thân.', 'ACTIVE'),
('Các thể loại: Sách giáo khoa, Giáo trình các môn học, Tài liệu giảng dạy.', 'Sách giáo khoa - Giáo trình', 'Sách phục vụ cho việc học tập, giảng dạy và nghiên cứu.', 'ACTIVE'),
('Các thể loại: Sách tham khảo ngành học, Hướng dẫn nghiên cứu, Sách giúp ôn thi, Học liệu bổ trợ.', 'Sách tham khảo', 'Sách tham khảo phục vụ học tập và nghiên cứu chuyên sâu.', 'ACTIVE'),
('Các thể loại: Sách học tiếng Anh, Sách học tiếng Pháp, Sách học tiếng Nhật, Các phương pháp học ngôn ngữ hiệu quả.', 'Sách học ngoại ngữ', 'Sách về việc học các ngoại ngữ và phát triển kỹ năng ngôn ngữ.', 'ACTIVE'),
('Các thể loại: Phát triển trí tuệ, Giáo dục cảm xúc, Kỹ năng sống cho trẻ, Tâm lý trẻ em.', 'Nuôi dạy con', 'Sách về việc nuôi dạy con cái và giáo dục trẻ em.', 'ACTIVE'),
('Các thể loại: Kiến thức tổng hợp, Sách giải trí, Thông tin hữu ích trong cuộc sống.', 'Sách kiến thức tổng hợp', 'Sách cung cấp kiến thức đa dạng về nhiều lĩnh vực.', 'ACTIVE'),
('Các thể loại: Từ điển tiếng Việt, Từ điển ngoại ngữ, Từ điển chuyên ngành.', 'Từ điển', 'Sách từ điển và các tài liệu tra cứu.', 'ACTIVE'),
('Các thể loại: Khoa học tự nhiên, Kỹ thuật công nghiệp, Công nghệ thông tin, Kỹ thuật phần mềm.', 'Sách Khoa học - Kỹ thuật', 'Sách về các lĩnh vực khoa học và công nghệ.', 'ACTIVE'),
('Các thể loại: Lập trình, Phát triển phần mềm, An ninh mạng, Khoa học máy tính.', 'Sách công nghệ thông tin', 'Sách về công nghệ thông tin và lập trình.', 'ACTIVE'),
('Các thể loại: Kinh sách, Tôn giáo, Tâm linh, Thiền định.', 'Sách Tôn giáo - Tâm linh', 'Sách về tôn giáo và các vấn đề tâm linh.', 'ACTIVE'),
('Các thể loại: Chính trị học, Pháp luật, Quyền con người, Chính trị quốc tế.', 'Sách Chính trị - Pháp lý', 'Sách về chính trị, pháp lý và các vấn đề xã hội.', 'ACTIVE'),
('Các thể loại: Văn hóa thế giới, Địa lý các quốc gia, Du lịch trong nước và quốc tế.', 'Sách Văn hoá - Địa lý - Du lịch', 'Sách về văn hoá, địa lý và du lịch.', 'ACTIVE'),
('Các thể loại: Tâm lý học, Phân tích hành vi con người, Giới tính, Quan hệ xã hội.', 'Sách Tâm lý - Giới tính', 'Sách về tâm lý học và các vấn đề giới tính.', 'ACTIVE'),
('Các thể loại: Y học cổ truyền, Y học hiện đại, Phòng chống bệnh tật, Tư vấn sức khỏe.', 'Sách Y học', 'Sách về y học và sức khỏe con người.', 'ACTIVE'),
('Các thể loại: Lịch sử thế giới, Lịch sử các quốc gia, Các chiến tranh, Các nền văn minh cổ đại.', 'Sách Lịch sử', 'Sách về lịch sử và các sự kiện lịch sử nổi bật.', 'ACTIVE'),
('Các thể loại: Sách về gia đình, Sách giải trí, Các câu chuyện cuộc sống, Hướng dẫn nuôi dưỡng gia đình.', 'Sách thưởng thức - Gia đình', 'Sách về các chủ đề gia đình, thưởng thức và đời sống.', 'ACTIVE'),
('Các thể loại: Phim ảnh, Âm nhạc, Các thể loại hội họa, Nghệ thuật biểu diễn.', 'Điện ảnh - Nhạc - Họa', 'Sách về điện ảnh, âm nhạc và hội họa.', 'ACTIVE'),
('Các thể loại: Thể thao, Dinh dưỡng thể thao, Tập luyện thể chất, Lối sống khỏe mạnh.', 'Thể dục - Thể thao', 'Sách về thể dục, thể thao và sức khỏe.', 'ACTIVE'),
('Các thể loại: Sách đa dạng về các lĩnh vực khác nhau, Tài liệu đặc biệt, Sách nghiên cứu.', 'Khác', 'Các sách thuộc các thể loại khác không có trong các danh mục trên.', 'ACTIVE');

-- 6. Table Sub_Category:
INSERT INTO sub_category (full_script, name, short_script, status, category_id) VALUES
-- Tiểu thuyết & Văn học
('Các tác phẩm văn hóa dân gian và thần thoại từ các nền văn hóa khác nhau, bao gồm truyện cổ tích, truyền thuyết, và các thần thoại đặc trưng.', 'Văn hóa dân gian & Thần thoại', 'Tìm hiểu về các tác phẩm văn hóa dân gian', 'ACTIVE', 1),
('Các tác phẩm liên quan đến lịch sử, bao gồm tiểu sử, sự kiện lịch sử, và những nhân vật lịch sử nổi tiếng.', 'Lịch sử', 'Khám phá các tác phẩm lịch sử', 'ACTIVE', 1),
('Các tác phẩm viễn tưởng, khoa học viễn tưởng và những tưởng tượng về thế giới tương lai, vũ trụ, và các công nghệ tiên tiến.', 'Viễn tưởng', 'Thế giới viễn tưởng và khoa học', 'ACTIVE', 1),
('Các tác phẩm kinh dị với nội dung ma quái, rùng rợn, về thế giới siêu nhiên và những câu chuyện ghê rợn.', 'Kinh dị', 'Những câu chuyện kinh dị và huyền bí', 'ACTIVE', 1),
('Các tác phẩm với chủ đề bí ẩn, bao gồm những vụ án chưa có lời giải, các hiện tượng kỳ lạ và chưa được lý giải.', 'Bí ẩn', 'Khám phá những bí ẩn chưa giải đáp', 'ACTIVE', 1),
('Các tác phẩm trinh thám với các vụ án hóc búa, nơi những thám tử tài ba giải quyết những vụ việc phức tạp và rối ren.', 'Trinh thám', 'Câu chuyện trinh thám và phá án', 'ACTIVE', 1),
('Các tác phẩm tâm lý, mô tả những nghiên cứu về hành vi con người, các trạng thái tâm lý phức tạp và mối quan hệ giữa các cá nhân.', 'Tâm lý', 'Khám phá những câu chuyện tâm lý', 'ACTIVE', 1),
('Các tác phẩm châm biếm, phê phán các vấn đề xã hội, chính trị, hoặc nhân văn qua lối viết hài hước và sắc sảo.', 'Châm biếm', 'Sự hài hước và phê phán xã hội', 'ACTIVE', 1),
('Các tác phẩm tiểu thuyết kể về cuộc đời, tình yêu, cuộc chiến tranh, hay những thử thách mà các nhân vật phải đối mặt trong cuộc sống.', 'Tiểu thuyết', 'Tiểu thuyết kể về những cuộc đời con người', 'ACTIVE', 1),
('Các tác phẩm phóng sự, ký sự và bút ký phản ánh những sự kiện thực tế, những câu chuyện thực về cuộc sống và con người.', 'Phóng sự - Ký sự - Bút ký', 'Những câu chuyện phóng sự và ký sự', 'ACTIVE', 1),
('Các tác phẩm phê bình văn học, nghiên cứu lý luận, và phân tích các tác phẩm văn học từ nhiều góc độ khác nhau.', 'Phê Bình - Lý luận văn học', 'Đánh giá và phân tích tác phẩm văn học', 'ACTIVE', 1),
('Các tác phẩm thơ với những bài thơ đặc sắc, truyền tải cảm xúc và suy nghĩ sâu sắc về cuộc sống, tình yêu, và thiên nhiên.', 'Thơ', 'Thơ ca về cuộc sống và tình yêu', 'ACTIVE', 1),
('Các tác phẩm du ký, mô tả những chuyến đi, khám phá những vùng đất mới, và các nền văn hóa khác nhau trên thế giới.', 'Du ký', 'Những câu chuyện du lịch và trải nghiệm', 'ACTIVE', 1),
('Các tác phẩm văn học kinh điển, những cuốn sách được xem là bất hủ, có ảnh hưởng lớn đến văn hóa và tư tưởng nhân loại.', 'Tác phẩm kinh điển', 'Những tác phẩm văn học kinh điển', 'ACTIVE', 1),
('Các tác phẩm truyện cổ tích, ngụ ngôn với những bài học quý giá về đạo đức, tình bạn, và lòng dũng cảm.', 'Truyện cổ tích - Ngụ ngôn', 'Những câu chuyện cổ tích và ngụ ngôn', 'ACTIVE', 1),
('Các tác phẩm tiểu sử và hồi ký, kể về cuộc đời và sự nghiệp của những nhân vật nổi tiếng trong lịch sử, văn học, và nghệ thuật.', 'Tiểu sử - Hồi ký', 'Hành trình cuộc đời của những nhân vật nổi tiếng', 'ACTIVE', 1),
('Các tác phẩm tiểu thuyết đen, mô tả những câu chuyện tội ác, điều tra và những hành động bất lương trong xã hội.', 'Tiểu thuyết đen', 'Những câu chuyện về tội ác và suy đồi xã hội', 'ACTIVE', 1),
('Các tác phẩm truyện tranh, nơi các câu chuyện được thể hiện qua hình ảnh và lời thoại, thích hợp cho mọi lứa tuổi và sở thích.', 'Truyện tranh', 'Những câu chuyện qua hình ảnh', 'ACTIVE', 1),
('Các tác phẩm truyện cười với những tình huống hài hước, giúp người đọc thư giãn và giải trí.', 'Truyện cười', 'Hài hước và vui nhộn', 'ACTIVE', 1),
('Các tác phẩm đam mỹ, chủ yếu là các câu chuyện tình yêu giữa các nhân vật nam, được yêu thích trong cộng đồng độc giả trẻ tuổi.', 'Đam mỹ', 'Câu chuyện tình yêu giữa các nhân vật nam', 'ACTIVE', 1),
('Các tác phẩm ngôn tình, với những câu chuyện tình yêu lãng mạn, cảm động, thường có kết thúc hạnh phúc.', 'Ngôn tình', 'Những câu chuyện tình yêu lãng mạn', 'ACTIVE', 1),
('Các tác phẩm ca dao, tục ngữ, thành ngữ phản ánh những tri thức và kinh nghiệm sống của dân tộc qua nhiều thế hệ.', 'Ca dao - Tục ngữ - Thành ngữ', 'Những câu ca dao, tục ngữ, thành ngữ truyền thống', 'ACTIVE', 1),
('Các tác phẩm sách ảnh, nơi những câu chuyện được kể qua hình ảnh, thích hợp cho những người yêu thích nghệ thuật và nhiếp ảnh.', 'Sách ảnh', 'Những câu chuyện được kể qua hình ảnh', 'ACTIVE', 1),

-- Sách thiếu nhi
('Các tác phẩm truyện cổ tích dân gian, bao gồm các câu chuyện truyền thống kể về những nhân vật kỳ diệu, những bài học đạo đức và phép màu.', 'Truyện cổ tích', 'Những câu chuyện cổ tích dân gian', 'ACTIVE', 2),
('Các tác phẩm truyện tranh thiếu nhi, với các hình ảnh sinh động và câu chuyện dễ hiểu, giúp trẻ em phát triển tư duy sáng tạo và hiểu biết về thế giới.', 'Truyện tranh thiếu nhi', 'Truyện tranh dành cho trẻ em', 'ACTIVE', 2),
('Các tác phẩm văn học thiếu nhi, bao gồm những câu chuyện, bài học cuộc sống, và những cuộc phiêu lưu dành cho trẻ em, giúp trẻ phát triển trí tưởng tượng và kỹ năng đọc.', 'Văn học thiếu nhi', 'Văn học cho trẻ em', 'ACTIVE', 2),
('Các tác phẩm đạo đức và kỹ năng sống, giúp trẻ em hiểu được các giá trị đạo đức cơ bản như lòng trung thực, sự tôn trọng, và cách đối phó với các tình huống trong cuộc sống.', 'Đạo đức - Kỹ năng sống', 'Đạo đức và kỹ năng sống cho trẻ em', 'ACTIVE', 2),
('Các tác phẩm kiến thức và bách khoa, cung cấp thông tin hữu ích và những bài học về thế giới xung quanh trẻ em, từ khoa học, tự nhiên đến xã hội.', 'Kiến thức - Bách khoa', 'Kiến thức và bách khoa cho trẻ em', 'ACTIVE', 2),
('Các tác phẩm tô màu và luyện chữ, giúp trẻ em phát triển khả năng nhận diện màu sắc, tư duy sáng tạo và rèn luyện kỹ năng viết chữ qua các bài tập vui nhộn.', 'Tô màu - Luyện chữ', 'Tô màu và luyện chữ cho trẻ em', 'ACTIVE', 2),
('Các tác phẩm truyện kể cho bé, bao gồm những câu chuyện ngắn, dễ hiểu, thú vị, giúp trẻ em phát triển kỹ năng ngôn ngữ và tư duy mạch lạc.', 'Truyện kể cho bé', 'Truyện ngắn cho trẻ em', 'ACTIVE', 2),
('Các tác phẩm sách chuyển động và tương tác, nơi trẻ em có thể tham gia vào các hoạt động và khám phá thông qua các tính năng tương tác, giúp phát triển khả năng tư duy và sáng tạo của trẻ.', 'Sách chuyển động - Tương tác', 'Sách chuyển động và tương tác cho trẻ em', 'ACTIVE', 2),

-- Sách kinh tế
('Các bài học kinh doanh chia sẻ những chiến lược, kinh nghiệm và bài học thực tế trong việc xây dựng và phát triển một doanh nghiệp thành công.', 'Bài học kinh doanh', 'Các bài học kinh doanh thiết thực', 'ACTIVE', 3),
('Các sách viết về doanh nhân, bao gồm những câu chuyện thành công, hành trình phát triển nghề nghiệp và những kinh nghiệm quý báu từ những người sáng lập doanh nghiệp nổi bật.', 'Sách doanh nhân', 'Các sách về doanh nhân', 'ACTIVE', 3),
('Các sách cung cấp những kiến thức và chiến lược cần thiết cho quá trình khởi nghiệp, từ việc lên ý tưởng đến xây dựng một doanh nghiệp bền vững.', 'Sách khởi nghiệp', 'Khởi nghiệp', 'ACTIVE', 3),
('Các sách về kinh tế học, từ lý thuyết cơ bản đến các nghiên cứu chuyên sâu, giúp người đọc hiểu về các mô hình kinh tế, chính sách và các vấn đề toàn cầu.', 'Sách kinh tế học', 'Kinh tế học', 'ACTIVE', 3),
('Các sách về kỹ năng làm việc giúp phát triển những kỹ năng cần thiết trong môi trường làm việc, bao gồm kỹ năng lãnh đạo, giao tiếp, giải quyết vấn đề và làm việc nhóm.', 'Sách kỹ năng làm việc', 'Kỹ năng làm việc', 'ACTIVE', 3),
('Các sách về marketing và bán hàng, chia sẻ các chiến lược tiếp thị, nghiên cứu thị trường, cũng như các phương pháp bán hàng hiệu quả để thúc đẩy doanh thu và phát triển thương hiệu.', 'Sách Marketing - Bán hàng', 'Marketing và Bán hàng', 'ACTIVE', 3),
('Các sách về quản trị và lãnh đạo, cung cấp kiến thức và chiến lược để lãnh đạo hiệu quả, quản lý đội ngũ, và xây dựng văn hóa doanh nghiệp mạnh mẽ.', 'Sách quản trị, lãnh đạo', 'Quản trị và lãnh đạo', 'ACTIVE', 3),
('Các sách về quản trị nhân lực, giúp các nhà quản lý hiểu và áp dụng các chiến lược tuyển dụng, đào tạo, và duy trì nhân viên trong tổ chức.', 'Sách quản trị nhân lực', 'Quản trị nhân lực', 'ACTIVE', 3),
('Các sách về tài chính, cung cấp kiến thức về quản lý tài chính cá nhân, doanh nghiệp, đầu tư, và các vấn đề tài chính toàn cầu giúp người đọc hiểu và ra quyết định tài chính đúng đắn.', 'Sách tài chính', 'Tài chính', 'ACTIVE', 3),

-- Sách kỹ năng sống
('Các sách giúp phát triển tư duy phản biện, sáng tạo và cải thiện các kỹ năng sống, giúp người đọc đối mặt với thách thức trong cuộc sống và công việc một cách hiệu quả.', 'Sách tư duy - Kỹ năng sống', 'Tư duy và Kỹ năng sống', 'ACTIVE', 4),
('Các sách cung cấp những lời khuyên, chiến lược và phương pháp để xác định và theo đuổi con đường sự nghiệp phù hợp, giúp người đọc phát triển nghề nghiệp một cách bền vững.', 'Sách hướng nghiệp', 'Hướng nghiệp', 'ACTIVE', 4),
('Các sách về kỹ năng mềm giúp người đọc cải thiện các kỹ năng giao tiếp, làm việc nhóm, quản lý thời gian, giải quyết vấn đề và các kỹ năng cần thiết trong môi trường công sở.', 'Sách kỹ năng mềm', 'Kỹ năng mềm', 'ACTIVE', 4),
('Các sách về tâm lý học giúp người đọc hiểu hơn về hành vi con người, các nguyên lý tâm lý, cũng như các phương pháp để cải thiện mối quan hệ và phát triển cá nhân.', 'Sách tâm lý học', 'Tâm lý học', 'ACTIVE', 4),

-- Sách giáo khoa - Giáo trình
('Các sách giáo khoa cung cấp kiến thức cơ bản về các môn học dành cho học sinh lớp 1, giúp xây dựng nền tảng học tập vững chắc.', 'Sách giáo khoa cấp 1', 'Giáo khoa cấp 1', 'ACTIVE', 5),
('Các sách giáo khoa cho học sinh cấp 2, với nội dung phù hợp cho từng lớp học từ lớp 6 đến lớp 9, giúp học sinh phát triển kiến thức chuyên sâu.', 'Sách giáo khoa cấp 2', 'Giáo khoa cấp 2', 'ACTIVE', 5),
('Các sách giáo khoa dành cho học sinh cấp 3, cung cấp kiến thức chuẩn bị cho kỳ thi tốt nghiệp và các môn học chuyên sâu cho học sinh phổ thông.', 'Sách giáo khoa cấp 3', 'Giáo khoa cấp 3', 'ACTIVE', 5),
('Các giáo trình cung cấp kiến thức chuyên ngành cho sinh viên đại học và cao đẳng, từ các môn cơ bản đến các môn chuyên sâu, giúp sinh viên trang bị nền tảng vững chắc cho nghề nghiệp tương lai.', 'Giáo trình Đại học - Cao đẳng', 'Giáo trình ĐH-CĐ', 'ACTIVE', 5),

-- Sách tham khảo
('Các sách tham khảo dành cho học sinh cấp 1, cung cấp kiến thức bổ sung và nâng cao cho các môn học cơ bản, hỗ trợ học sinh trong việc ôn tập và mở rộng kiến thức.', 'Sách tham khảo cấp 1', 'Tham khảo cấp 1', 'ACTIVE', 6),
('Các sách tham khảo dành cho học sinh cấp 2, giúp học sinh củng cố kiến thức các môn học và chuẩn bị tốt hơn cho các kỳ thi giữa kỳ, cuối kỳ.', 'Sách tham khảo cấp 2', 'Tham khảo cấp 2', 'ACTIVE', 6),
('Các sách tham khảo dành cho học sinh cấp 3, với nội dung sâu sắc giúp học sinh ôn luyện cho các kỳ thi quan trọng như thi tốt nghiệp THPT và kỳ thi đại học.', 'Sách tham khảo cấp 3', 'Tham khảo cấp 3', 'ACTIVE', 6),
('Các sách luyện thi dành cho học sinh chuẩn bị thi đại học và cao đẳng, bao gồm các bài tập, đề thi mẫu, và chiến lược ôn thi hiệu quả.', 'Sách luyện thi Đại học - Cao đẳng', 'Luyện thi', 'ACTIVE', 6),
('Các sách chuyên đề cung cấp kiến thức chuyên sâu về một chủ đề cụ thể, giúp học sinh, sinh viên hiểu rõ hơn về lĩnh vực mình quan tâm hoặc chuẩn bị cho kỳ thi chuyên môn.', 'Sách chuyên đề', 'Chuyên đề', 'ACTIVE', 6),

-- Sách học ngoại ngữ
('Các sách học Tiếng Anh giúp người học cải thiện kỹ năng nghe, nói, đọc, viết và nâng cao khả năng giao tiếp trong tiếng Anh.', 'Sách học Tiếng Anh', 'Tiếng Anh', 'ACTIVE', 7),
('Các sách học Tiếng Nhật giúp người học nắm vững các kỹ năng cơ bản trong tiếng Nhật, bao gồm từ vựng, ngữ pháp và giao tiếp.', 'Sách học Tiếng Nhật', 'Tiếng Nhật', 'ACTIVE', 7),
('Các sách học Tiếng Hàn giúp người học phát triển các kỹ năng ngôn ngữ cần thiết để giao tiếp hiệu quả trong môi trường nói tiếng Hàn.', 'Sách học Tiếng Hàn', 'Tiếng Hàn', 'ACTIVE', 7),
('Các sách học các ngoại ngữ khác ngoài tiếng Anh, tiếng Nhật và tiếng Hàn, bao gồm các ngôn ngữ như tiếng Trung, tiếng Pháp, tiếng Đức, và các ngôn ngữ khác.', 'Ngoại ngữ khác', 'Ngoại ngữ khác', 'ACTIVE', 7),

-- Nuôi dạy con
('Các sách cung cấp kiến thức và phương pháp thai giáo giúp phát triển thể chất và tinh thần cho trẻ trong suốt quá trình mang thai.', 'Sách thai giáo', 'Thai giáo', 'ACTIVE', 8),
('Các sách về kiến thức và kỹ năng thiết yếu cho trẻ, giúp trẻ phát triển toàn diện về tư duy và kỹ năng sống.', 'Sách kiến thức - Kỹ năng cho trẻ', 'Kiến thức cho trẻ', 'ACTIVE', 8),
('Các sách cẩm nang cung cấp thông tin và lời khuyên hữu ích cho các bà mẹ trong quá trình nuôi dạy con cái từ sơ sinh đến trưởng thành.', 'Cẩm nang làm mẹ', 'Làm mẹ', 'ACTIVE', 8),
('Các sách về dinh dưỡng và chăm sóc sức khỏe cho bé, giúp các bậc phụ huynh có kiến thức đúng đắn về chế độ ăn uống và chăm sóc sức khỏe cho trẻ.', 'Sách dinh dưỡng - Sức khoẻ cho bé', 'Dinh dưỡng', 'ACTIVE', 8),
('Các phương pháp giáo dục trẻ, bao gồm các kỹ thuật và chiến lược giúp trẻ phát triển về mặt tâm lý và học tập hiệu quả.', 'Phương pháp giáo dục trẻ', 'Giáo dục trẻ', 'ACTIVE', 8),

-- Sách kiến thức tổng hợp
('Các sách về triết học, giúp người đọc hiểu sâu hơn về các lý thuyết triết học, tầm ảnh hưởng và các trường phái triết học khác nhau.', 'Triết học', 'Triết học', 'ACTIVE', 9),
('Các sách về giáo dục, bao gồm các lý thuyết, phương pháp giảng dạy và các cách thức nâng cao chất lượng giáo dục.', 'Sách giáo dục', 'Giáo dục', 'ACTIVE', 9),
('Các sách về kiến thức bách khoa, cung cấp thông tin toàn diện về các lĩnh vực khoa học, công nghệ và xã hội.', 'Kiến thức Bách khoa', 'Bách khoa', 'ACTIVE', 9),
('Các sách về chiêm tinh và horoscope, giải thích các hiện tượng thiên văn và ảnh hưởng của chúng đến cuộc sống con người.', 'Sách Chiêm tinh - Horoscope', 'Chiêm tinh', 'ACTIVE', 9),
('Các sách về phong thủy và kinh dịch, chia sẻ kiến thức về cách thức tạo lập môi trường sống hài hòa và thịnh vượng.', 'Sách Phong thuỷ - Kinh dịch', 'Phong thuỷ', 'ACTIVE', 9),
('Các sách thuộc lĩnh vực khác, bao gồm các chủ đề đa dạng ngoài các danh mục đã được phân loại.', 'Lĩnh vực khác', 'Lĩnh vực khác', 'ACTIVE', 9);

INSERT INTO sub_category (full_script, name, short_script, status, category_id) VALUES
-- Từ điển
('Các từ điển tiếng Anh, cung cấp các định nghĩa, từ vựng và cách sử dụng tiếng Anh trong các ngữ cảnh khác nhau.', 'Từ điển Tiếng Anh', 'Từ điển Anh', 'ACTIVE', 10),
('Các từ điển tiếng Trung, cung cấp thông tin về từ vựng, ngữ pháp và cách sử dụng tiếng Trung trong giao tiếp hàng ngày.', 'Từ điển Tiếng Trung', 'Từ điển Trung', 'ACTIVE', 10),
('Các từ điển tiếng Hàn, giúp người học hiểu rõ hơn về từ vựng và cấu trúc ngữ pháp trong tiếng Hàn.', 'Từ điển Tiếng Hàn', 'Từ điển Hàn', 'ACTIVE', 10),
('Các từ điển tiếng Pháp, giải thích các từ vựng và các cấu trúc ngữ pháp của ngôn ngữ Pháp, phục vụ cho việc học và giao tiếp.', 'Từ điển Pháp', 'Từ điển Pháp', 'ACTIVE', 10),
('Các từ điển ngôn ngữ khác, bao gồm các ngôn ngữ khác ngoài tiếng Anh, Trung, Hàn và Pháp.', 'Từ điển Ngôn ngữ khác', 'Từ điển khác', 'ACTIVE', 10),

-- Sách Khoa học - Kỹ thuật
('Các sách về khoa học, bao gồm các lĩnh vực như vật lý, hóa học, sinh học, vũ trụ học và các nghiên cứu khoa học khác.', 'Sách khoa học', 'Khoa học', 'ACTIVE', 11),
('Các sách về kỹ thuật, cung cấp kiến thức về các công nghệ, thiết bị và phương pháp kỹ thuật ứng dụng trong các ngành công nghiệp.', 'Sách kỹ thuật', 'Kỹ thuật', 'ACTIVE', 11),

-- Sách công nghệ thông tin
('Các sách về tin học văn phòng, bao gồm các phần mềm như Microsoft Office, Excel, Word, PowerPoint, và các kỹ năng sử dụng phần mềm văn phòng khác.', 'Tin học văn phòng', 'Tin học VP', 'ACTIVE', 12),
('Các sách về lập trình, bao gồm các ngôn ngữ lập trình như Java, Python, C++, C#, và các chủ đề liên quan đến phát triển phần mềm.', 'Lập trình', 'Lập trình', 'ACTIVE', 12),
('Các sách về thiết kế đồ họa, bao gồm các phần mềm thiết kế như Adobe Photoshop, Illustrator, cùng các kỹ thuật và nguyên lý thiết kế đồ họa.', 'Thiết kế - Đồ hoạ', 'Thiết kế', 'ACTIVE', 12),

-- Sách Tôn giáo - Tâm linh
('Các sách về công giáo, bao gồm các tác phẩm tôn giáo, lịch sử và giáo lý của Công giáo.', 'Công giáo', 'Công giáo', 'ACTIVE', 13),
('Các sách về Phật giáo, bao gồm các tác phẩm tôn giáo, giáo lý, và thực hành của Phật giáo.', 'Phật giáo', 'Phật giáo', 'ACTIVE', 13),
('Các sách về tôn giáo và tâm linh khác, bao gồm các tác phẩm về các tín ngưỡng, tôn giáo và triết lý tâm linh ngoài Công giáo và Phật giáo.', 'Tôn giáo - Tâm linh khác', 'Tôn giáo khác', 'ACTIVE', 13),

-- Sách Chính trị - Pháp lý
('Các sách về lý luận chính trị, bao gồm các tác phẩm nghiên cứu, phân tích về chính trị và lý thuyết chính trị.', 'Lý luận chính trị', 'Chính trị', 'ACTIVE', 14),
('Các sách về luật và văn bản pháp lý, bao gồm các tài liệu pháp lý, bộ luật, và các nghiên cứu về hệ thống pháp luật.', 'Luật - Văn bản Luật', 'Luật', 'ACTIVE', 14),

-- Sách Văn hoá - Địa lý - Du lịch
('Các sách về địa danh và du lịch, giới thiệu về các điểm đến du lịch, danh lam thắng cảnh, và văn hóa địa phương.', 'Sách Địa danh - Du lịch', 'Địa danh - Du lịch', 'ACTIVE', 15),
('Các sách về phong tục và tập quán, tìm hiểu về các truyền thống, lễ hội, và tập quán của các cộng đồng trên thế giới.', 'Sách Phong tục - Tập quán', 'Phong tục - Tập quán', 'ACTIVE', 15);

INSERT INTO sub_category (full_script, name, short_script, status, category_id) VALUES
-- Sách Tâm lý - Giới tính
('Các sách về tâm lý tuổi dậy thì, giúp hiểu rõ về những thay đổi trong tâm lý và cảm xúc của tuổi dậy thì.', 'Sách tâm lý tuổi dậy thì', 'Tâm lý tuổi dậy thì', 'ACTIVE', 16),
('Các sách về hôn nhân và giới tính, khám phá các khía cạnh của cuộc sống hôn nhân, tình yêu và các vấn đề giới tính.', 'Sách Hôn nhân - Giới tính', 'Hôn nhân - Giới tính', 'ACTIVE', 16),

-- Sách Y học
('Các sách về y học cổ truyền, nghiên cứu và thực hành phương pháp chữa bệnh truyền thống.', 'Sách Y học cổ truyền', 'Y học cổ truyền', 'ACTIVE', 17),
('Các sách về y học hiện đại, cập nhật kiến thức và phương pháp điều trị y khoa hiện đại.', 'Sách Y học hiện đại', 'Y học hiện đại', 'ACTIVE', 17),
('Các sách khác về y học, bao gồm các chủ đề và phương pháp y học không thuộc cổ truyền hay hiện đại.', 'Sách Y học khác', 'Y học khác', 'ACTIVE', 17),

-- Sách Lịch sử
('Các sách về lịch sử Việt Nam, các sự kiện và nhân vật quan trọng trong lịch sử dân tộc.', 'Lịch sử Việt Nam', 'Lịch sử Việt Nam', 'ACTIVE', 18),
('Các sách về lịch sử thế giới, các sự kiện và biến cố lớn trong lịch sử nhân loại.', 'Lịch sử Thế Giới', 'Lịch sử Thế Giới', 'ACTIVE', 18),

-- Các mục thuộc category_id 19 (Sách thưởng thức - Gia đình)
('Các sách về chăm sóc sức khoẻ, các phương pháp duy trì sức khỏe và phòng ngừa bệnh tật.', 'Chăm sóc sức khoẻ', 'Chăm sóc sức khoẻ', 'ACTIVE', 19),
('Các sách về may, thêu và thời trang, kỹ thuật may mặc và xu hướng thời trang.', 'May - Thêu - Thời trang', 'May - Thêu - Thời trang', 'ACTIVE', 19),
('Các sách về làm đẹp, phương pháp và mẹo vặt trong làm đẹp cá nhân.', 'Sách làm đẹp', 'Làm đẹp', 'ACTIVE', 19),
('Các sách về nấu ăn, công thức và kỹ thuật chế biến món ăn.', 'Sách Nấu ăn', 'Nấu ăn', 'ACTIVE', 19),

-- Điện ảnh - Nhạc - Họa
('Các sách về âm nhạc và điện ảnh, các thể loại âm nhạc, lịch sử điện ảnh, và các đạo diễn nổi tiếng.', 'Âm nhạc - Điện ảnh', 'Âm nhạc - Điện ảnh', 'ACTIVE', 20),
('Các sách về mỹ thuật và kiến trúc, từ các tác phẩm nổi tiếng đến lý thuyết thiết kế và sáng tạo nghệ thuật.', 'Mỹ thuật - Kiến trúc', 'Mỹ thuật - Kiến trúc', 'ACTIVE', 20),

-- Thể dục - Thể thao
('Các sách về chạy bộ, kỹ thuật chạy, và các chương trình luyện tập chạy bộ.', 'Chạy bộ', 'Chạy bộ', 'ACTIVE', 21),
('Các sách về thể thao đối kháng như võ thuật, quyền anh, và MMA.', 'Đối kháng', 'Đối kháng', 'ACTIVE', 21),
('Các sách về cờ vua, cờ tướng, và các môn thể thao trí tuệ khác.', 'Thể thao trí tuệ', 'Thể thao trí tuệ', 'ACTIVE', 21),
('Các sách về các môn thể dục, thể thao và các hoạt động thể chất khác.', 'Thể dục - Thể thao khác', 'Thể dục - Thể thao khác', 'ACTIVE', 21),

-- Khác
('Các sách về nông, lâm và ngư nghiệp.', 'Sách Nông - Lâm - Ngư nghiệp', 'Nông - Lâm - Ngư nghiệp', 'ACTIVE', 22),
('Các loại tạp chí và catalogue.', 'Tạp chí - Catalogue', 'Tạp chí - Catalogue', 'ACTIVE', 22),
('Các loại sách khác không thuộc các chuyên mục đã đề cập.', 'Khác', 'Khác', 'ACTIVE', 22);

-- 7. Table Publisher:
INSERT INTO publisher (avatar, introduction, join_at, name) VALUES
('https://pos.nvncdn.com/a91a50-31439/brand/20180830_RmWPaV3Vj0uKH2CvmadRt7xl.jpg', 'NXB Trẻ chuyên xuất bản sách dành cho thanh thiếu niên và trẻ em, với nhiều thể loại phong phú từ tiểu thuyết đến truyện tranh.', '2015-03-10 10:30:00', 'NXB Trẻ'),
('https://pos.nvncdn.com/a91a50-31439/brand/20180830_RmWPaV3Vj0uKH2CvmadRt7xl.jpg', 'NXB Giáo Dục là nhà xuất bản uy tín chuyên cung cấp các sách giáo khoa, giáo trình và tài liệu học tập cho hệ thống giáo dục Việt Nam.', '2010-06-15 09:00:00', 'NXB Giáo Dục'),
('https://pos.nvncdn.com/a91a50-31439/brand/20180830_RmWPaV3Vj0uKH2CvmadRt7xl.jpg', 'NXB Kim Đồng nổi tiếng với các ấn phẩm dành cho trẻ em, bao gồm truyện tranh, sách thiếu nhi và các hoạt động giáo dục sáng tạo.', '2008-09-20 14:45:00', 'NXB Kim Đồng'),
('https://pos.nvncdn.com/a91a50-31439/brand/20180830_RmWPaV3Vj0uKH2CvmadRt7xl.jpg', 'NXB Văn Học chuyên xuất bản các tác phẩm văn học cổ điển và hiện đại, bao gồm tiểu thuyết, truyện ngắn và thơ ca của các tác giả Việt Nam và quốc tế.', '2012-11-05 16:20:00', 'NXB Văn Học'),
('https://pos.nvncdn.com/a91a50-31439/brand/20180830_RmWPaV3Vj0uKH2CvmadRt7xl.jpg', 'NXB Nguyễn Trãi tập trung vào các ấn phẩm nghiên cứu, sách lịch sử và sách tham khảo, phục vụ nhu cầu học tập và nghiên cứu của độc giả.', '2014-02-18 11:15:00', 'NXB Nguyễn Trãi'),
('https://pos.nvncdn.com/a91a50-31439/brand/20180830_RmWPaV3Vj0uKH2CvmadRt7xl.jpg', 'NXB Gia Tộc chuyên xuất bản các cuốn sách về văn hóa, lịch sử và các giá trị gia đình, mang đến những câu chuyện sâu sắc và ý nghĩa.', '2016-07-22 13:50:00', 'NXB Gia Tộc'),
('https://pos.nvncdn.com/a91a50-31439/brand/20180830_RmWPaV3Vj0uKH2CvmadRt7xl.jpg', 'NXB Kiến Thức cung cấp các sách tham khảo, sách kỹ năng và sách chuyên đề về nhiều lĩnh vực khác nhau, từ khoa học đến nghệ thuật.', '2013-05-30 08:30:00', 'NXB Kiến Thức'),
('https://pos.nvncdn.com/a91a50-31439/brand/20180830_RmWPaV3Vj0uKH2CvmadRt7xl.jpg', 'NXB Thành Viên là nhà xuất bản chuyên về các ấn phẩm khoa học, sách chuyên ngành và tài liệu nghiên cứu dành cho học giả và nhà nghiên cứu.', '2011-12-12 17:05:00', 'NXB Thành Viên'),
('https://pos.nvncdn.com/a91a50-31439/brand/20180830_RmWPaV3Vj0uKH2CvmadRt7xl.jpg', 'NXB Pháp Luật chuyên xuất bản các sách về luật pháp, quy định và các tài liệu pháp lý, phục vụ cho ngành nghề luật sư và học viên ngành luật.', '2009-08-08 12:00:00', 'NXB Pháp Luật'),
('https://pos.nvncdn.com/a91a50-31439/brand/20180830_RmWPaV3Vj0uKH2CvmadRt7xl.jpg', 'NXB Sách Doanh Nghiệp cung cấp các ấn phẩm về quản trị kinh doanh, marketing, phát triển cá nhân và kỹ năng lãnh đạo, hỗ trợ các doanh nhân và nhà quản lý.', '2017-04-25 15:40:00', 'NXB Sách Doanh Nghiệp');


-- 8. Table Book:
INSERT INTO book (code_ISBN10, code_ISBN13, `condition`, description, edition, format, 
    hand_cover, height, length, publication_date, recommended_age, 
    selling_price, title, weight, width, category_id, publisher_id, sub_category_id
) VALUES
('1234567890', '9781234567897', 'NEW', 'TRÊN ĐƯỜNG BĂNG là cuốn sách tập hợp những bài viết truyền cảm hứng và hướng dẫn kỹ năng cho các bạn trẻ khi chuẩn bị bước vào đời.', 1, 'PAPERBACK', 308, 20.0, 13.0, '2022-01-15 10:00:00', 'ALL_AGES', 150000, 'Trên đường băng', 0.5, 1.2, 4, 1, 44),
('0987654321', '9780987654321', 'NEW', 'Sách - Tầm Nhìn Giáo Dục
Có những người luôn đau đáu tìm hướng đi cho nền giáo dục hiện tại, có những người đi tìm định hướng cho việc phát triển các năng lực và giá trị bản thân, có người lại đi tìm cách thức/phương pháp đúng đắn để giáo dục con em hay thế hệ sau. Tất cả những nhân duyên quý báu đó có thể dẫn chúng ta đến một giao điểm: tìm hiểu, nghiên cứu và thực hành giáo dục.
Nhìn lại thực trạng của nền giáo dục Việt Nam hiện nay, điều đáng mừng là chưa bao giờ chúng ta lại dành nhiều thời gian, tiền bạc, của cải, nỗ lực và tâm huyết cho Giáo dục & Phát triển con người đến thế. Rất nhiều ngôi trường lớn đã mọc lên, rất nhiều trường phái và phương pháp giáo dục mới ra đời hoặc được du nhập từ nước ngoài, để truyền dạy kiến thức, kỹ năng, huấn luyện và đào tạo. Nhưng thực tế là nhiều người làm giáo dục và cả người nhận sự giáo dục đều chưa chạm được đến bản chất cốt lõi của giáo dục, chủ thể của giáo dục, phương tiện thực sự của giáo dục và cái đích chân chính mà giáo dục hướng tới. Điều này dẫn đến sự manh mún, hình thức, chắp vá, giáo điều và không có một mục đích nhất quán, xuyên suốt trong giáo dục ở nhiều nơi.
Đã đến lúc chúng ta cần có một con đường Giáo dục mới với tinh thần mới – “Giáo Dục Đích Thực”: khai phóng những tiềm năng thực sự đẹp đẽ, kỳ diệu bên trong mỗi con người; đồng thời giúp họ gột rửa, chuyển hóa được những thứ xấu xí đang cản trở những tiềm năng ấy phát lộ, nảy nở và bung tỏa. Từ sự khai mở ấy, con người có đủ sức mạnh để giải quyết những vấn đề mâu thuẫn nội tại và dựng xây một cuộc sống viên mãn, hạnh phúc đích thực.
Cuốn sách Tầm Nhìn Giáo Dục không những khơi gợi cho bạn đọc những tầm nhìn và giải pháp mới mang tính triệt để, rốt ráo để giải quyết những vấn đề đang tồn tại, mà còn mở ra một tầm nhìn và giải pháp đột phá để kiến tạo một nền Giáo dục Đích thực cho nhiều con người. Cuốn sách cũng như một món quà quý giá trao gửi tới độc giả là những người thực sự tâm huyết với giáo dục, sự nghiệp giáo dục, với phát triển bản thân, con người và xã hội.', 1, 'HARDCOVER', 224, 24.0, 16.0, '2021-06-20 11:30:00', 'ALL_AGES', 180000, 'Tầm nhìn giáo dục', 0.6, 1.3, 1, 2, 14),
('1122334455', '9781122334455', 'NEW', 'Đừng Lựa Chọn An Nhàn Khi Còn Trẻ
Trong độ xuân xanh phơi phới ngày ấy, bạn không dám mạo hiểm, không dám nỗ lực để kiếm học bổng, không chịu tìm tòi những thử thách trong công việc, không phấn đấu hướng đến ước mơ của mình. Bạn mơ mộng rằng làm việc xong sẽ vào làm ở một công ty nổi tiếng, làm một thời gian sẽ thăng quan tiến chức. Mơ mộng rằng khởi nghiệp xong sẽ lập tức nhận được tiền đầu tư, cầm được tiền đầu tư là sẽ niêm yết trên sàn chứng khoán. Mơ mộng rằng muốn gì sẽ có đó, không thiếu tiền cũng chẳng thiếu tình, an hưởng những năm tháng êm đềm trong cuộc đời mình.
Nhưng vì sao bạn lại nghĩ rằng bạn chẳng cần bỏ ra chút công sức nào, cuộc sống sẽ dâng đến tận miệng những thứ bạn muốn? Bạn cần phải hiểu rằng: Hấp tấp muốn mau chóng thành công rất dễ khiến chúng ta đi vào mê lộ. Thanh xuân là khoảng thời gian đẹp đẽ nhất trong đời, cũng là những năm tháng then chốt có thể quyết định tương lai của một người. Nếu bạn lựa chọn an nhàn trong 10 năm, tương lai sẽ buộc bạn phải vất vả trong 50 năm để bù đắp lại. Nếu bạn bươn chải vất vả trong 10 năm, thứ mà bạn chắc chắn có được là 50 năm hạnh phúc. Điều quý giá nhất không phải là tiền mà là tiền bạc.
Thế nên, bạn à, đừng lựa chọn an nhàn khi còn trẻ.', 2, 'PAPERBACK', 316, 20.0, 13.0, '2019-08-10 09:45:00', '16_TO_18_YEARS_OLD', 170000, 'Đừng lựa chọn an nhàn khi còn trẻ', 0.45, 1.1, 4, 3, 44),
('6677889900', '9786677889900', 'USED', 'Hai cuốn sách trước của Giáo sư Phan Văn Trường, Một đời thương thuyết và Một đời quản trị, là sự chắt lọc từ những trải nghiệm trong suốt nhiều năm tháng nghề nghiệp của bản thân. Tuy nhiên, đến với cuốn sách này, tác giả lại muốn dành một khoảng không gian riêng để có thể phản ảnh những cảm nhận cá nhân về cuộc sống, với góc nhìn từ những năm tháng tuổi trẻ cho đến độ tuổi xế chiều này.
Khoảnh khắc khó chịu nhất có lẽ là khi mình đã lỡ chọn một hướng đi, nhưng ngộ được rằng con đường này nhiều chông gai, lắm rào cản và lại còn không phù hợp. Trong lòng, lúc ấy chỉ muốn được quay trở lại để bắt đầu, để lựa chọn lại một hướng khôn ngoan hơn. 
Việc lựa chọn tất nhiên đòi hỏi nhiều sáng suốt, nhưng trên hết người lựa chọn phải hiểu rõ thế giới mà mình đang sống và biết rõ chính mình muốn gì, và một mặt khác phải sẵn sàng cáng đáng lấy trách nhiệm trong sự lựa chọn. Nói một cách hoa mỹ hơn, mình chỉ tìm ra hướng đi đúng đắn và phù hợp cho bản thân nếu thấu hiểu rõ bản năng, bản ngã và cả tiềm thức của chính mình. Cùng một tinh thần luôn sẵn sàng đối mặt với những hệ quả tốt và xấu từ sự lựa chọn ấy.', 1, 'HARDCOVER', 414, 22.5, 14.5, '2018-05-18 13:20:00', 'OVER_18_YEARS_OLD', 200000, 'Một đời như kẻ tìm đường', 0.55, 1.3, 4, 4, 44),
('5566778899', '9785566778899', 'NEW', '“Bạn hối tiếc vì không nắm bắt lấy một cơ hội nào đó, chẳng có ai phải mất ngủ.
Bạn trải qua những ngày tháng nhạt nhẽo với công việc bạn căm ghét, người ta chẳng hề bận lòng.
Bạn có chết mòn nơi xó tường với những ước mơ dang dở, đó không phải là việc của họ.
Suy cho cùng, quyết định là ở bạn. Muốn có điều gì hay không là tùy bạn.
Nên hãy làm những điều bạn thích. Hãy đi theo tiếng nói trái tim. Hãy sống theo cách bạn cho là mình nên sống.
Vì sau tất cả, chẳng ai quan tâm.”
“Tôi đã đọc quyển sách này một cách thích thú. Có nhiều kiến thức và kinh nghiệm hữu ích, những điều mới mẻ ngay cả với người gần trung niên như tôi.
Tuổi trẻ đáng giá bao nhiêu? được tác giả chia làm 3 phần: HỌC, LÀM, ĐI.
Nhưng tôi thấy cuốn sách còn thể hiện một phần thứ tư nữa, đó là ĐỌC.
Hãy đọc sách, nếu bạn đọc sách một cách bền bỉ, sẽ đến lúc bạn bị thôi thúc không ngừng bởi ý muốn viết nên cuốn sách của riêng mình.
Nếu tôi còn ở tuổi đôi mươi, hẳn là tôi sẽ đọc Tuổi trẻ đáng giá bao nhiêu? nhiều hơn một lần.”', 1, 'PAPERBACK', 370, 21.0, 14.0, '2020-09-25 15:00:00', '16_TO_18_YEARS_OLD', 130000, 'Tuổi trẻ đáng giá bao nhiêu', 0.4, 1.1, 4, 5, 44),
('3344556677', '9783344556677', 'NEW', 'Đắc Nhân Tâm
Đắc nhân tâm (tên tiếng Anh là How to Win Friends and Influence People) là một trong những cuốn sách về chủ đề nghệ thuật ứng xử và giao tiếp thành công nhất, bán chạy nhất và được biết đến nhiều nhất cho đến tận ngày nay, đưa tên tuổi của Dale Carnegie vang danh khắp thế giới.
Dale Carnegie từng nói, việc kiếm được một triệu đô la vẫn dễ hơn thêm một cụm từ vào từ điển tiếng Anh. Vậy mà Đắc nhân tâm đã trở thành một cụm từ như thế: được trích dẫn, diễn giải, tái chế; được sử dụng trong vô số bối cảnh, từ phim hoạt hình, chính trị cho tới tiểu thuyết. Bản thân cuốn sách cũng được dịch sang hầu hết các ngôn ngữ được biết đến trên thế giới. Mỗi thế hệ lại khám phá tác phẩm theo một cách hoàn toàn mới và tìm ra những giá trị vẫn hữu dụng trong thời đại của họ.
Cho đến ngày nay, cuốn sách vẫn đang từng bước hoàn thiện để trở nên hoàn hảo hơn, phù hợp với nhu cầu ngày một phát triển. Bản tu chỉnh mới này sẽ không có một sự thay đổi nào ngoại trừ cắt tỉa một vài chi tiết, thêm vào một số ví dụ gần gũi hơn với bối cảnh đương thời. Phong cách viết như diễn thuyết, lối trò chuyện bình dị, gần gũi mà không kém phần hoa lệ của tác giả Dale Carnegie sẽ làm rõ hơn những ý nghĩa của cuốn sách đối với độc giả hiện đại, mà không làm xáo trộn nội dung của tác phẩm.
Hàng nghìn người đang đọc và học hỏi từ Đắc nhân tâm, tìm thấy cảm hứng trong việc áp dụng các nguyên tắc trong đó để có cuộc sống tốt đẹp hơn.
Đắc nhân tâm sẽ giúp bạn:
- Thoát khỏi tư duy lối mòn, hình thành các suy nghĩ mới, có được tầm nhìn mới và khám phá được những tham vọng mới.
- Gia tăng sự mến mộ và tín nhiệm của mọi người đối với bạn.
- Xử lý những ý kiến trái chiều, tránh những bất đồng và giữ các quan hệ luôn suôn sẻ, dễ chịu.
- Kết bạn nhanh chóng và dễ dàng hơn.
- Thuyết phục mọi người đồng tình với ý kiến của mình.
- Gia tăng sức ảnh hưởng và uy danh trong công việc.
- Trở thành diễn giả tốt hơn và là một người giao tiếp thú vị hơn.
- Khơi dậy lòng nhiệt huyết của các đồng sự.', 2, 'HARDCOVER', 360, 24.0, 16.0, '2015-10-10 14:30:00', 'ALL_AGES', 250000, 'Đắc nhân tâm', 0.7, 1.4, 4, 6, 44),
('4455667788', '9784455667788', 'USED', 'Tư Duy Ngược
Chúng ta thực sự có hạnh phúc không? Chúng ta có đang sống cuộc đời mình không? Chúng ta có dám dũng cảm chiến thắng mọi khuôn mẫu, định kiến, đi ngược đám đông để khẳng định bản sắc riêng của mình không?. Có bao giờ bạn tự hỏi như thế, rồi có câu trả lời cho chính mình?
Tôi biết biết, không phải ai cũng đang sống cuộc đời của mình, không phải ai cũng dám vượt qua mọi lối mòn để sáng tạo và thành công… Dựa trên việc nghiên cứu, tìm hiểu, chắt lọc, tìm kiếm, ghi chép từ các câu chuyện trong đời sống, cũng như trải nghiệm của bản thân, tôi viết cuốn sách này.
Cuốn sách sẽ giải mã bạn là ai, bạn cần Tư duy ngược để thành công và hạnh phúc như thế nào và các phương pháp giúp bạn dũng cảm sống cuộc đời mà bạn muốn.', 1, 'PAPERBACK', 214, 19.0, 12.5, '2021-02-22 12:10:00', 'ALL_AGES', 140000, 'Tư duy ngược', 0.35, 1.0, 4, 7, 44),
('2233445566', '9782233445566', 'NEW', 'Cuốn sách này thực sự đã giúp đỡ cho hàng triệu độc giả, trong đó có tôi và chắc chắn cũng sẽ có bạn. Nếu không có những ý niệm mới mẻ này thì chưa chắc tôi đã có được cuộc hôn nhân hạnh phúc như hiện nay hay có thể trở thành một người cha giàu đức hy sinh đối với các con của mình như vậy. Những vướng mắc trong mối quan hệ với vợ cách đây hai mươi năm đã từng làm tôi tức điên lên, hiện giờ thi thoảng nó vẫn thường xảy ra. Nhưng điều khác biệt là tôi đã biết khoan dung hơn, chấp nhận và thấu hiểu hơn. Tôi có thể hiểu những lời lẽ và phản ứng của vợ tôi theo cách khách quan hơn, đồng thời tôi biết cách nên đáp lại như thế nào. Có thể tôi là một chuyên gia trong lĩnh vực giao tiếp và sự khác biệt về giới tính, tuy nhiên, đối với Bonnie và các cô con gái của tôi thì việc để hiều được họ vẫn còn là những bí ẩn. Dù vậy, cuốn sách này có thể giúp chúng ta trở nên khoan dung và biết tha thứ khi ai đó không đáp lại theo cách mà ta mong đợi. May mắn thay, để xây dựng những mối quan hệ bền đẹp, tính hoàn hảo không phải là điều kiện bắt buộc.
Với những áp lực công việc ngày càng gia tăng, cùng với những đòi hỏi nhiều hơn về sự lãng mạn trong gia đình, ngày nay những mối quan hệ dường như đang thách thức hầu hết mọi người. Hiểu được người bạn đời của mình tới từ đâu sẽ giúp mối quan hệ của bạn trở nên nhẹ nhàng hơn. Bao dung với những điều khác biệt giữa hai người không có nghĩa là chấp nhận một cách thụ động mối quan hệ đầy vấn đề hoặc thiếu cảm xúc đam mê. Thay vào đó, sự thích nghi lành mạnh này dựa trên nền tảng thấu hiểu thực sự, điều đó sẽ giúp chúng ta cảm thông với người bạn đời hơn, đối đáp với họ bằng nhiều tình yêu hơn và truyền cảm hứng tốt nhất đến với họ. Bạn không thể và cũng không nên cố thay đổi người bạn đời của mình. Thay đổi là việc của họ, còn việc của bạn là thay đổi cách giao tiếp, phản ứng và đối đáp với người bạn đời của mình. Bằng sự thấu hiểu mới mẻ này, bạn sẽ có thêm sức mạnh và sự thông thái để điều chỉnh cách tiếp cận của mình. Từ việc giao tiếp tốt hơn, bạn sẽ biết cách trợ giúp hiệu quả hơn, đồng thời bạn sẽ thành công hơn khi nhận được sự trợ giúp mà bạn muốn.
Có nhiều người áp dụng sai những khái niệm trong cuốn sách này. Họ dùng ví dụ và giải thích này của tôi để bào chữa cho việc không chịu thay đổi những khía cạnh quan trọng giúp mối quan hệ trở nên tốt đẹp hơn. Chẳng hạn, tôi chỉ ra rằng đàn ông cần chui vào chiếc kén của mình thường
xuyên để thư giãn mỗi ngày. Tuy nhiên điều này không thể trở thành lý do biện minh cho việc ở lì trong đó cả ngày. Mặt khác, tôi cũng chỉ ra rằng phụ nữ nói chung thường có nhu cầu chia sẻ cảm xúc nhiều hơn đàn ông, như là một cách để đương đầu với sự căng thẳng của mình. Điều này không có nghĩa là họ có thể nói không ngừng hoặc mong chờ đàn ông phải dừng việc của họ lại để lắng nghe bất kỳ điều gì cô ấy nói hay bất cứ khi nào cô ấy muốn. Thật không may là nhiều khi những ý niệm tốt cũng có thể bị áp dụng sai. Nhưng nếu bạn đang tìm cách dùng những ý niệm này để hiểu thêm về người bạn đời của mình, để tôn trọng người khác theo cách mà họ cho là quan trọng, cũng như để người khác hiểu được những nhu cầu của mình thì cuốn sách này có thể giúp ích cho bạn.
Trên những hành trình của mình, trong lúc đợi máy bay hoặc khi ký tên lên những cuốn sách trong một sự kiện nào đó, tôi luôn gặp những đôi vợ chồng tới tìm tôi với cùng một câu chuyện. Họ đã từng li dị nhưng sau khi đọc “cuốn sách này” họ lại tái hôn và sống hạnh phúc bên nhau. Khi tôi viết cuốn Đàn ông đến từ Sao Hỏa, đàn bà đến từ Sao Kim từ mười hai năm trước, tôi biết cuốn sách này sẽ thặt chặt các mối quan hệ hơn và thậm chí còn có thể cứu vãn nhiều cuộc hôn nhân đang trên bờ vực li hôn. Điều tôi không thể ngờ là lại có nhiều người tái hợp với bạn đời của mình sau một cuộc li hôn hoặc li thân để cùng bắt đầu và dựng xây lại mối quan hệ đó. Chắc chắn sẽ có nhiều người nói rằng cuốn sách này không thể cứu vãn một mối quan hệ vướng phải những vấn đề nghiêm trọng và cho rằng họ sống tốt hơn khi không có bạn đời. Nhiều người nói rằng việc đọc cuốn sách này khi mối quan hệ của họ đã thất bại cũng giúp họ hiểu được nguyên do vì sao mối quan hệ đó không thể lâu bền. Hiểu được điều đó giúp họ có thêm can đảm để tiếp tục yêu và nắm giữ bí quyết để tìm được tình yêu.
Hầu hết những ai đọc cuốn sách này đều có thể cải thiện chất lượng mối quan hệ mà họ đang có. Chắc chắn bạn sẽ khám phá ra những ý niệm mới mẻ để cải thiện việc giao tiếp và đạt được những mục đích của riêng mình. Thậm chí nếu một ý tưởng nào đó có thể giúp bạn thấu hiểu cũng như hỗ trợ cho bạn đời, bạn bè, đồng nghiệp, cha mẹ hoặc con cái, thì điều đó cũng xứng đáng với sự quan tâm và thời gian mà bạn đã đầu tư cho nó rồi. Một thay đổi dù nhỏ nhưng có tầm quan trọng có thể mang lại những ảnh hưởng sâu sắc và lâu dài. Thật bất ngờ, một ý tưởng giúp mối quan hệ trở nên bền vững hơn cũng có thể hỗ trợ các cặp đôi vượt qua những trở ngại đầy thách thức của họ. Cuốn sách này không đề cập trực tiếp tới những thách thức của “một mối quan hệ rối loạn” nhưng nó mang lại hướng tiếp cận mới với người khác giới. Khi thấu hiểu, việc giao tiếp sẽ tự động được cải thiện. Khi sự hợp tác giữa hai người tốt hơn, hy vọng sẽ nhiều hơn và tình yêu sẽ ngự trị. Chỉ cần có tình yêu và cách thức giao tiếp tốt, hầu hết mọi vấn đề, thậm chí cả “những vấn đề lớn” đều có thể giải quyết. Đầu tiên hãy đề cập đến những vấn đề nhỏ, từ đó những vấn đề lớn sẽ dần biến mất hoặc được giải quyết một cách dễ dàng.', 1, 'HARDCOVER', 419, 22.0, 14.0, '2019-07-15 16:40:00', 'OVER_18_YEARS_OLD', 190000, 'Đàn ông sao hỏa đàn bà sao kim', 0.5, 1.2, 4, 8, 44),
('4455332211', '9784455332211', 'NEW', '“Vị chua chát của cái nghèo hòa trộn với vị ngọt ngào khi khám phá ra những điều khiến cuộc đời này đáng sống... một tác phẩm kinh điển của Brazil.” - Booklist
“Một cách nhìn cuộc sống gần như hoàn chỉnh từ con mắt trẻ thơ… có sức mạnh sưởi ấm và làm tan nát cõi lòng, dù người đọc ở lứa tuổi nào.” - The National
Hãy làm quen với Zezé, cậu bé tinh nghịch siêu hạng đồng thời cũng đáng yêu bậc nhất, với ước mơ lớn lên trở thành nhà thơ cổ thắt nơ bướm. Chẳng phải ai cũng công nhận khoản “đáng yêu” kia đâu nhé. Bởi vì, ở cái xóm ngoại ô nghèo ấy, nỗi khắc khổ bủa vây đã che mờ mắt người ta trước trái tim thiện lương cùng trí tưởng tượng tuyệt vời của cậu bé con năm tuổi.
Có hề gì đâu bao nhiêu là hắt hủi, đánh mắng, vì Zezé đã có một người bạn đặc biệt để trút nỗi lòng: cây cam ngọt nơi vườn sau. Và cả một người bạn nữa, bằng xương bằng thịt, một ngày kia xuất hiện, cho cậu bé nhạy cảm khôn sớm biết thế nào là trìu mến, thế nào là nỗi đau, và mãi mãi thay đổi cuộc đời cậu.
Mở đầu bằng những thanh âm trong sáng và kết thúc lắng lại trong những nốt trầm hoài niệm, Cây cam ngọt của tôi khiến ta nhận ra vẻ đẹp thực sự của cuộc sống đến từ những điều giản dị như bông hoa trắng của cái cây sau nhà, và rằng cuộc đời thật khốn khổ nếu thiếu đi lòng yêu thương và niềm trắc ẩn. Cuốn sách kinh điển này bởi thế không ngừng khiến trái tim người đọc khắp thế giới thổn thức, kể từ khi ra mắt lần đầu năm 1968 tại Brazil.', 1, 'PAPERBACK', 244, 23.0, 15.0, '2020-12-12 10:00:00', '16_TO_18_YEARS_OLD', 120000, 'Cây cam ngọt của tôi', 0.6, 1.3, 1, 9, 9),
('5544332211', '9785544332211', 'NEW', 'Khi hơi thở hóa thinh không là tự truyện của một bác sĩ bị mắc bệnh ung thư phổi. Trong cuốn sách này, tác giả đã chia sẻ những trải nghiệm từ khi mới bắt đầu học ngành y, tiếp xúc với bệnh nhân cho tới khi phát hiện ra mình bị ung thư và phải điều trị lâu dài.
Kalanithi rất yêu thích văn chương nên câu chuyện của anh đã được thuật lại theo một phong cách mượt mà, dung dị và đầy cảm xúc. Độc giả cũng được hiểu thêm về triết lý sống, triết lý nghề y của Kalanithi, thông qua ký ức về những ngày anh còn là sinh viên, rồi thực tập, cho đến khi chính thức hành nghề phẫu thuật thần kinh. “Đối với bệnh nhân và gia đình, phẫu thuật não là sự kiện bi thảm nhất mà họ từng phải đối mặt và nó có tác động như bất kỳ một biến cố lớn lao trong đời. Trong những thời điểm nguy cấp đó, câu hỏi không chỉ đơn thuần là sống hay chết mà còn là cuộc sống nào đáng sống.” – Kalanithi luôn biết cách đưa vào câu chuyện những suy nghĩ sâu sắc và đầy sự đồng cảm như thế.
Bạn bè và gia đình đã dành tặng những lời trìu mến nhất cho con người đáng kính trọng cả về tài năng lẫn nhân cách này. Dù không thể vượt qua cơn bệnh nan y, nhưng thông điệp của tác giả sẽ còn khiến người đọc nhớ mãi.', 1, 'HARDCOVER', 236, 24.0, 16.0, '2017-11-25 11:15:00', 'OVER_18_YEARS_OLD', 180000, 'Khi hơi thở hóa thinh không', 0.65, 1.4, 1, 10, 16);

-- 8. Table Author:
-- Thêm dữ liệu vào bảng author
INSERT INTO author (avatar, introduction, join_at, name) VALUES
('https://kenh14cdn.com/203336854389633024/2022/4/9/1732920193150637133093626329146106221360649n-164947443607057196887.jpeg', 
 'Tác giả nổi tiếng với những tác phẩm về kỹ năng sống và định hướng tuổi trẻ.', 
 '2019-01-15 10:00:00', 
 'Tony Buổi Sáng'),

('https://kenh14cdn.com/203336854389633024/2022/4/9/1732920193150637133093626329146106221360649n-164947443607057196887.jpeg', 
 'Chuyên gia giáo dục và nhà nghiên cứu với nhiều tác phẩm truyền cảm hứng.', 
 '2018-05-25 09:30:00', 
 'Thầy Trần Thế Công'),

('https://kenh14cdn.com/203336854389633024/2022/4/9/1732920193150637133093626329146106221360649n-164947443607057196887.jpeg', 
 'Nhà văn trẻ, viết nhiều về trải nghiệm tuổi trẻ và sự nghiệp.', 
 '2020-07-10 14:20:00', 
 'Cảnh Thiên'),

('https://kenh14cdn.com/203336854389633024/2022/4/9/1732920193150637133093626329146106221360649n-164947443607057196887.jpeg', 
 'Tác giả chuyên viết về hành trình và mục đích sống.', 
 '2016-03-14 11:45:00', 
 'Phan Văn Trường'),

('https://kenh14cdn.com/203336854389633024/2022/4/9/1732920193150637133093626329146106221360649n-164947443607057196887.jpeg', 
 'Tác giả nổi tiếng với các sách kỹ năng sống và phát triển cá nhân.', 
 '2017-08-22 15:30:00', 
 'Rosie Nguyễn'),

('https://kenh14cdn.com/203336854389633024/2022/4/9/1732920193150637133093626329146106221360649n-164947443607057196887.jpeg', 
 'Nhà văn và chuyên gia về giao tiếp và các mối quan hệ xã hội.', 
 '2015-09-05 13:50:00', 
 'Dale Carnegie'),

('https://kenh14cdn.com/203336854389633024/2022/4/9/1732920193150637133093626329146106221360649n-164947443607057196887.jpeg', 
 'Tác giả nổi tiếng với phong cách viết khác biệt, tư duy mới lạ.', 
 '2019-12-01 10:10:00', 
 'Nguyễn Anh Dũng'),

('https://kenh14cdn.com/203336854389633024/2022/4/9/1732920193150637133093626329146106221360649n-164947443607057196887.jpeg', 
 'Chuyên gia về mối quan hệ và khác biệt tâm lý giữa giới tính.', 
 '2021-03-17 09:20:00', 
 'John Gray'),

('https://kenh14cdn.com/203336854389633024/2022/4/9/1732920193150637133093626329146106221360649n-164947443607057196887.jpeg', 
 'Nhà văn nổi tiếng với những câu chuyện về gia đình và tuổi thơ.', 
 '2018-11-29 12:30:00', 
 'José Mauro de Vasconcelos'),

('https://kenh14cdn.com/203336854389633024/2022/4/9/1732920193150637133093626329146106221360649n-164947443607057196887.jpeg', 
 'Bác sĩ và tác giả, chuyên viết về y học và ý nghĩa cuộc sống.', 
 '2020-02-24 14:45:00', 
 'Paul Kalanithi');

-- 9. Table Author_Book:
-- Thêm dữ liệu vào bảng author_book (mỗi sách với một tác giả khác nhau)
INSERT INTO author_book (author_id, book_id) VALUES
(1, 1),  -- Trên đường băng
(2, 2),  -- Tầm nhìn giáo dục
(3, 3),  -- Đừng lựa chọn an nhàn khi còn trẻ
(4, 4),  -- Một đời như kẻ tìm đường
(5, 5),  -- Tuổi trẻ đáng giá bao nhiêu
(6, 6),  -- Đắc nhân tâm
(7, 7),  -- Tư duy ngược
(8, 8),  -- Đàn ông sao hỏa đàn bà sao kim
(9, 9),  -- Cây cam ngọt của tôi
(10, 10);  -- Khi hơi thở hóa thinh không

-- 10.Table Translator:
INSERT INTO translator (avatar, introduction, join_at, name) VALUES
('https://kenh14cdn.com/203336854389633024/2022/4/9/1732920193150637133093626329146106221360649n-164947443607057196887.jpeg', 
 'Dịch giả nổi tiếng với các tác phẩm dịch thuật trong lĩnh vực văn học và giáo dục.', 
 '2019-01-15 10:00:00', 
 'Trần Văn Bình'),

('https://kenh14cdn.com/203336854389633024/2022/4/9/1732920193150637133093626329146106221360649n-164947443607057196887.jpeg', 
 'Chuyên gia dịch thuật trong lĩnh vực phát triển bản thân và kỹ năng sống.', 
 '2020-06-20 11:30:00', 
 'Lê Thanh Hương'),

('https://kenh14cdn.com/203336854389633024/2022/4/9/1732920193150637133093626329146106221360649n-164947443607057196887.jpeg', 
 'Dịch giả có kinh nghiệm dịch các sách về tâm lý và giáo dục.', 
 '2018-09-10 09:45:00', 
 'Nguyễn Thị Hồng'),

('https://kenh14cdn.com/203336854389633024/2022/4/9/1732920193150637133093626329146106221360649n-164947443607057196887.jpeg', 
 'Dịch giả chuyên về các tác phẩm văn học nổi tiếng trên thế giới.', 
 '2017-03-25 15:00:00', 
 'Phạm Minh Châu'),

('https://kenh14cdn.com/203336854389633024/2022/4/9/1732920193150637133093626329146106221360649n-164947443607057196887.jpeg', 
 'Dịch giả với nhiều kinh nghiệm dịch sách khoa học và tự truyện.', 
 '2021-12-01 13:20:00', 
 'Vũ Văn Hải');

-- 11. Translator_book:
INSERT INTO translator_book (translator_id, book_id) VALUES
(1, 3),  -- Trên đường băng
(2, 6),  -- Tầm nhìn giáo dục
(3, 8),  -- Đừng lựa chọn an nhàn khi còn trẻ
(4, 9),  -- Một đời như kẻ tìm đường
(5, 10);  -- Tuổi trẻ đáng giá bao nhiêu

-- 12. Table Review
INSERT INTO review (content, created_at, is_hidden, rate, ready_to_introduce, book_id, customer_id) VALUES
-- Đánh giá của customer_id = 1 cho 5 cuốn sách đầu
('Cuốn sách rất hay và bổ ích, đáng để đọc.', '2023-01-05 09:30:00', 0, 5, 1, 1, 1),
('Rất hài lòng với nội dung, nhiều kiến thức bổ ích.', '2023-01-15 10:00:00', 0, 4, 1, 2, 1),
('Một tác phẩm tuyệt vời, cung cấp góc nhìn mới.', '2023-01-25 14:30:00', 0, 5, 1, 3, 1),
('Sách rất thú vị và truyền cảm hứng, tôi thích điều đó.', '2023-02-05 11:45:00', 0, 4, 1, 4, 1),
('Một cuốn sách đáng để giới thiệu cho mọi người.', '2023-02-15 13:20:00', 0, 5, 1, 5, 1),

-- Đánh giá của customer_id = 2 cho 5 cuốn sách đầu
('Nội dung rất sâu sắc và dễ hiểu, rất thích cuốn này.', '2023-01-10 08:45:00', 0, 5, 1, 1, 2),
('Sách có nhiều thông tin hữu ích cho người đọc.', '2023-01-20 09:15:00', 0, 4, 1, 2, 2),
('Tôi học được nhiều điều mới qua cuốn sách này.', '2023-01-30 15:10:00', 0, 5, 1, 3, 2),
('Rất hài lòng với cuốn sách, dễ đọc và thực tế.', '2023-02-10 10:25:00', 0, 4, 1, 4, 2),
('Cuốn sách rất phù hợp để phát triển bản thân.', '2023-02-20 12:40:00', 0, 5, 1, 5, 2);
-- 13. Table Address:
-- Địa chỉ cho owner
INSERT INTO address (detail, district, nation, province, village, owner_id) VALUES
('123 Lê Lợi', 'Quận 1', 'Việt Nam', 'TP HCM', 'Phường Bến Nghé', 1);

-- Địa chỉ cho staff 
INSERT INTO address (detail, district, nation, province, village, staff_id) VALUES
('456 Nguyễn Huệ', 'Quận 1', 'Việt Nam', 'TP HCM', 'Phường Bến Thành', 1),
('789 Trần Hưng Đạo', 'Quận 5', 'Việt Nam', 'TP HCM', 'Phường 7', 2);

-- Địa chỉ cho customer 
INSERT INTO address (detail, district, nation, province, village, customer_id) VALUES
('101 Nguyễn Đình Chiểu', 'Quận 3', 'Việt Nam', 'TP HCM', 'Phường 6', 1),
('102 Hai Bà Trưng', 'Quận 3', 'Việt Nam', 'TP HCM', 'Phường 8', 2),
('103 Lý Thái Tổ', 'Quận 10', 'Việt Nam', 'TP HCM', 'Phường 14', 3),
('104 Điện Biên Phủ', 'Quận Bình Thạnh', 'Việt Nam', 'TP HCM', 'Phường 25', 4),
('105 Bạch Đằng', 'Quận Tân Bình', 'Việt Nam', 'TP HCM', 'Phường 2', 5),
('106 Hoàng Văn Thụ', 'Quận Phú Nhuận', 'Việt Nam', 'TP HCM', 'Phường 9', 6),
('107 Nguyễn Văn Cừ', 'Quận 5', 'Việt Nam', 'TP HCM', 'Phường 4', 7),
('108 Trường Chinh', 'Quận Tân Bình', 'Việt Nam', 'TP HCM', 'Phường 15', 8),
('109 Phan Xích Long', 'Quận Phú Nhuận', 'Việt Nam', 'TP HCM', 'Phường 7', 9),
('110 Lê Quang Định', 'Quận Bình Thạnh', 'Việt Nam', 'TP HCM', 'Phường 14', 10),
('111 Hồng Bàng', 'Quận 5', 'Việt Nam', 'TP HCM', 'Phường 12', 11),
('112 Nguyễn Trãi', 'Quận 1', 'Việt Nam', 'TP HCM', 'Phường Phạm Ngũ Lão', 12),
('113 Cách Mạng Tháng Tám', 'Quận 3', 'Việt Nam', 'TP HCM', 'Phường 11', 13),
('114 Tô Hiến Thành', 'Quận 10', 'Việt Nam', 'TP HCM', 'Phường 13', 14),
('115 Phạm Văn Đồng', 'Quận Thủ Đức', 'Việt Nam', 'TP HCM', 'Phường Linh Đông', 15);


-- 13. Table Promotion: 
-- Thêm 10 mã COUPON
INSERT INTO promotion (code, created_at, description, discount_limit, effective_date, expiration_date, min_value_to_be_applied, percent_discount, status, title, type) VALUES
('COUPON1', '2024-11-01 09:00:00', 'Giảm giá 10% cho đơn hàng từ 100k', 50000, '2024-11-01 00:00:00', '2024-11-30 23:59:59', 100000, 10, 'EFFECTIVE', 'Khuyến mãi COUPON', 'COUPON'),
('COUPON2', '2024-11-02 10:00:00', 'Giảm giá 15% cho đơn hàng từ 200k', 70000, '2024-11-02 00:00:00', '2024-11-30 23:59:59', 200000, 15, 'NULL_AND_VOID', 'Khuyến mãi COUPON', 'COUPON'),
('COUPON3', '2024-11-03 11:00:00', 'Giảm giá 20% cho đơn hàng từ 300k', 100000, '2024-11-03 00:00:00', '2024-11-30 23:59:59', 300000, 20, 'USED_OUT', 'Khuyến mãi COUPON', 'COUPON'),
('COUPON4', '2024-11-04 12:00:00', 'Giảm giá 5% cho đơn hàng từ 50k', 30000, '2024-11-04 00:00:00', '2024-11-30 23:59:59', 50000, 5, 'EFFECTIVE', 'Khuyến mãi COUPON', 'COUPON'),
('COUPON5', '2024-11-05 13:00:00', 'Giảm giá 12% cho đơn hàng từ 150k', 60000, '2024-11-05 00:00:00', '2024-11-10 23:59:59', 150000, 12, 'EXPIRED', 'Khuyến mãi COUPON', 'COUPON'),
('COUPON6', '2024-11-06 14:00:00', 'Giảm giá 8% cho đơn hàng từ 120k', 40000, '2024-11-06 00:00:00', '2024-11-30 23:59:59', 120000, 8, 'EFFECTIVE', 'Khuyến mãi COUPON', 'COUPON'),
('COUPON7', '2024-11-07 15:00:00', 'Giảm giá 18% cho đơn hàng từ 250k', 80000, '2024-11-07 00:00:00', '2024-11-30 23:59:59', 250000, 18, 'USED_OUT', 'Khuyến mãi COUPON', 'COUPON'),
('COUPON8', '2024-11-08 16:00:00', 'Giảm giá 25% cho đơn hàng từ 350k', 150000, '2024-11-08 00:00:00', '2024-11-30 23:59:59', 350000, 25, 'EFFECTIVE', 'Khuyến mãi COUPON', 'COUPON'),
('COUPON9', '2024-11-09 17:00:00', 'Giảm giá 30% cho đơn hàng từ 500k', 200000, '2024-11-09 00:00:00', '2024-11-30 23:59:59', 500000, 30, 'NULL_AND_VOID', 'Khuyến mãi COUPON', 'COUPON'),
('COUPON10', '2024-11-10 18:00:00', 'Giảm giá 35% cho đơn hàng từ 700k', 250000, '2024-11-10 00:00:00', '2024-11-10 23:59:59', 700000, 35, 'EXPIRED', 'Khuyến mãi COUPON', 'COUPON');

-- Thêm 10 mã VOUCHER
INSERT INTO promotion (code, created_at, description, discount_limit, effective_date, expiration_date, min_value_to_be_applied, percent_discount, status, title, type) VALUES
('VOUCHER1', '2024-11-11 09:00:00', 'Giảm giá 20% cho đơn hàng từ 100k', 50000, '2024-11-11 00:00:00', '2024-11-30 23:59:59', 100000, 20, 'EFFECTIVE', 'Khuyến mãi VOUCHER', 'VOUCHER'),
('VOUCHER2', '2024-11-12 10:00:00', 'Giảm giá 25% cho đơn hàng từ 200k', 70000, '2024-11-12 00:00:00', '2024-11-30 23:59:59', 200000, 25, 'NULL_AND_VOID', 'Khuyến mãi VOUCHER', 'VOUCHER'),
('VOUCHER3', '2024-11-13 11:00:00', 'Giảm giá 30% cho đơn hàng từ 300k', 100000, '2024-11-13 00:00:00', '2024-11-30 23:59:59', 300000, 30, 'USED_OUT', 'Khuyến mãi VOUCHER', 'VOUCHER'),
('VOUCHER4', '2024-11-14 12:00:00', 'Giảm giá 10% cho đơn hàng từ 50k', 30000, '2024-11-14 00:00:00', '2024-11-30 23:59:59', 50000, 10, 'EFFECTIVE', 'Khuyến mãi VOUCHER', 'VOUCHER'),
('VOUCHER5', '2024-11-15 13:00:00', 'Giảm giá 15% cho đơn hàng từ 150k', 60000, '2024-11-15 00:00:00', '2024-11-10 23:59:59', 150000, 15, 'EXPIRED', 'Khuyến mãi VOUCHER', 'VOUCHER'),
('VOUCHER6', '2024-11-16 14:00:00', 'Giảm giá 18% cho đơn hàng từ 120k', 40000, '2024-11-16 00:00:00', '2024-11-30 23:59:59', 120000, 18, 'EFFECTIVE', 'Khuyến mãi VOUCHER', 'VOUCHER'),
('VOUCHER7', '2024-11-17 15:00:00', 'Giảm giá 22% cho đơn hàng từ 250k', 80000, '2024-11-17 00:00:00', '2024-11-30 23:59:59', 250000, 22, 'USED_OUT', 'Khuyến mãi VOUCHER', 'VOUCHER'),
('VOUCHER8', '2024-11-18 16:00:00', 'Giảm giá 28% cho đơn hàng từ 350k', 150000, '2024-11-18 00:00:00', '2024-11-30 23:59:59', 350000, 28, 'EFFECTIVE', 'Khuyến mãi VOUCHER', 'VOUCHER'),
('VOUCHER9', '2024-11-19 17:00:00', 'Giảm giá 35% cho đơn hàng từ 500k', 200000, '2024-11-19 00:00:00', '2024-11-30 23:59:59', 500000, 35, 'NULL_AND_VOID', 'Khuyến mãi VOUCHER', 'VOUCHER'),
('VOUCHER10', '2024-11-20 18:00:00', 'Giảm giá 40% cho đơn hàng từ 700k', 250000, '2024-11-20 00:00:00', '2024-11-10 23:59:59', 700000, 40, 'EXPIRED', 'Khuyến mãi VOUCHER', 'VOUCHER');

-- Thêm 10 mã FREESHIP
INSERT INTO promotion (code, created_at, description, discount_limit, effective_date, expiration_date, min_value_to_be_applied, percent_discount, status, title, type) VALUES
('FREESHIP1', '2024-11-21 09:00:00', 'Miễn phí vận chuyển cho đơn hàng từ 100k', 30000, '2024-11-21 00:00:00', '2024-11-30 23:59:59', 100000, 100, 'EFFECTIVE', 'Khuyến mãi FREESHIP', 'FREESHIP'),
('FREESHIP2', '2024-11-22 10:00:00', 'Miễn phí vận chuyển cho đơn hàng từ 200k', 30000, '2024-11-22 00:00:00', '2024-11-30 23:59:59', 200000, 100, 'NULL_AND_VOID', 'Khuyến mãi FREESHIP', 'FREESHIP'),
('FREESHIP3', '2024-11-23 11:00:00', 'Miễn phí vận chuyển cho đơn hàng từ 300k', 30000, '2024-11-23 00:00:00', '2024-11-30 23:59:59', 300000, 100, 'USED_OUT', 'Khuyến mãi FREESHIP', 'FREESHIP'),
('FREESHIP4', '2024-11-24 12:00:00', 'Miễn phí vận chuyển cho đơn hàng từ 50k', 15000, '2024-11-24 00:00:00', '2024-11-30 23:59:59', 50000, 100, 'EFFECTIVE', 'Khuyến mãi FREESHIP', 'FREESHIP'),
('FREESHIP5', '2024-11-25 13:00:00', 'Miễn phí vận chuyển cho đơn hàng từ 150k', 15000, '2024-11-25 00:00:00', '2024-11-10 23:59:59', 150000, 100, 'EXPIRED', 'Khuyến mãi FREESHIP', 'FREESHIP'),
('FREESHIP6', '2024-11-26 14:00:00', 'Miễn phí vận chuyển cho đơn hàng từ 120k', 15000, '2024-11-26 00:00:00', '2024-11-30 23:59:59', 120000, 100, 'EFFECTIVE', 'Khuyến mãi FREESHIP', 'FREESHIP'),
('FREESHIP7', '2024-11-27 15:00:00', 'Miễn phí vận chuyển cho đơn hàng từ 250k', 15000, '2024-11-27 00:00:00', '2024-11-30 23:59:59', 250000, 100, 'USED_OUT', 'Khuyến mãi FREESHIP', 'FREESHIP'),
('FREESHIP8', '2024-11-28 16:00:00', 'Miễn phí vận chuyển cho đơn hàng từ 350k', 15000, '2024-11-28 00:00:00', '2024-11-30 23:59:59', 350000, 100, 'EFFECTIVE', 'Khuyến mãi FREESHIP', 'FREESHIP'),
('FREESHIP9', '2024-11-29 17:00:00', 'Miễn phí vận chuyển cho đơn hàng từ 500k', 15000, '2024-11-29 00:00:00', '2024-11-30 23:59:59', 500000, 100, 'NULL_AND_VOID', 'Khuyến mãi FREESHIP', 'FREESHIP'),
('FREESHIP10', '2024-11-30 18:00:00', 'Miễn phí vận chuyển cho đơn hàng từ 700k', 15000, '2024-11-30 00:00:00', '2024-11-10 23:59:59', 700000, 100, 'EXPIRED', 'Khuyến mãi FREESHIP', 'FREESHIP');

-- Thêm 5 mã Discount
INSERT INTO promotion (code, created_at, description, discount_limit, effective_date, expiration_date, min_value_to_be_applied, percent_discount, status, title, type) VALUES
('DISCOUNT1', '2024-11-01 09:00:00', 'Giảm giá đặc biệt DISCOUNT1', 0, '2024-11-01 00:00:00', '2024-11-30 23:59:59', 0, 10, 'EFFECTIVE', 'Khuyến mãi DISCOUNT1', 'DISCOUNT'),
('DISCOUNT2', '2024-11-02 10:00:00', 'Giảm giá đặc biệt DISCOUNT2', 0, '2024-11-02 00:00:00', '2024-11-30 23:59:59', 0, 15, 'EFFECTIVE', 'Khuyến mãi DISCOUNT2', 'DISCOUNT'),
('DISCOUNT3', '2024-11-03 11:00:00', 'Giảm giá đặc biệt DISCOUNT3', 0, '2024-11-03 00:00:00', '2024-11-30 23:59:59', 0, 20, 'USED_OUT', 'Khuyến mãi DISCOUNT3', 'DISCOUNT'),
('DISCOUNT4', '2024-11-04 12:00:00', 'Giảm giá đặc biệt DISCOUNT4', 0, '2024-11-04 00:00:00', '2024-11-10 23:59:59', 0, 25, 'EXPIRED', 'Khuyến mãi DISCOUNT4', 'DISCOUNT'),
('DISCOUNT5', '2024-11-05 13:00:00', 'Giảm giá đặc biệt DISCOUNT5', 0, '2024-11-05 00:00:00', '2024-11-30 23:59:59', 0, 30, 'NULL_AND_VOID', 'Khuyến mãi DISCOUNT5', 'DISCOUNT');

-- 14. Table Promotion_Target:
INSERT INTO promotion_target (applicable_object_id, quantity, type, promotion_id) VALUES
('WHOLE', 30, 'WHOLE', 1),
('WHOLE', 30, 'WHOLE', 2),
('WHOLE', 30, 'WHOLE', 3),
('WHOLE', 30, 'WHOLE', 4),
('WHOLE', 30, 'WHOLE', 5),
('WHOLE', 30, 'WHOLE', 6),
('WHOLE', 30, 'WHOLE', 7),
('WHOLE', 30, 'WHOLE', 8),
('WHOLE', 30, 'WHOLE', 9),
('WHOLE', 30, 'WHOLE', 10),
('WHOLE', 30, 'WHOLE', 11),
('WHOLE', 30, 'WHOLE', 12),
('WHOLE', 30, 'WHOLE', 13),
('WHOLE', 30, 'WHOLE', 14),
('WHOLE', 30, 'WHOLE', 15),
('WHOLE', 30, 'WHOLE', 16),
('WHOLE', 30, 'WHOLE', 17),
('WHOLE', 30, 'WHOLE', 18),
('WHOLE', 30, 'WHOLE', 19),
('WHOLE', 30, 'WHOLE', 20),
('WHOLE', 30, 'WHOLE', 21),
('WHOLE', 30, 'WHOLE', 22),
('WHOLE', 30, 'WHOLE', 23),
('WHOLE', 30, 'WHOLE', 24),
('WHOLE', 30, 'WHOLE', 25),
('WHOLE', 30, 'WHOLE', 26),
('WHOLE', 30, 'WHOLE', 27),
('WHOLE', 30, 'WHOLE', 28),
('WHOLE', 30, 'WHOLE', 29),
('WHOLE', 30, 'WHOLE', 30);

-- promotion_id = 31
INSERT INTO promotion_target (applicable_object_id, quantity, type, promotion_id) VALUES
('1', NULL, 'BOOK', 31),
('2', NULL, 'BOOK', 31),
('3', NULL, 'BOOK', 31),
('4', NULL, 'BOOK', 31),
('5', NULL, 'BOOK', 31),
('6', NULL, 'BOOK', 31),
('7', NULL, 'BOOK', 31),
('8', NULL, 'BOOK', 31),
('9', NULL, 'BOOK', 31),
('10', NULL, 'BOOK', 31);

-- promotion_id = 32
INSERT INTO promotion_target (applicable_object_id, quantity, type, promotion_id) VALUES
('1', NULL, 'BOOK', 32),
('2', NULL, 'BOOK', 32),
('3', NULL, 'BOOK', 32),
('4', NULL, 'BOOK', 32),
('5', NULL, 'BOOK', 32),
('6', NULL, 'BOOK', 32),
('7', NULL, 'BOOK', 32),
('8', NULL, 'BOOK', 32),
('9', NULL, 'BOOK', 32),
('10', NULL, 'BOOK', 32);

-- 15. Table Notification:
INSERT INTO notification (content, created_at, hyper_link, sent_time, status, title, type) VALUES
('Nội dung thông báo 1', '2024-11-01 09:00:00', NULL, '2024-11-01 09:05:00', 'NOT_SEEN', 'Thông báo 1', 'ORDER'),
('Nội dung thông báo 2', '2024-11-02 10:00:00', NULL, '2024-11-02 10:05:00', 'VIEWED', 'Thông báo 2', 'SUPPORT'),
('Nội dung thông báo 3', '2024-11-03 11:00:00', NULL, '2024-11-03 11:05:00', 'NOT_SEEN', 'Thông báo 3', 'SYSTEM'),
('Nội dung thông báo 4', '2024-11-04 12:00:00', NULL, '2024-11-04 12:05:00', 'VIEWED', 'Thông báo 4', 'ORDER'),
('Nội dung thông báo 5', '2024-11-05 13:00:00', NULL, '2024-11-05 13:05:00', 'NOT_SEEN', 'Thông báo 5', 'SUPPORT'),
('Nội dung thông báo 6', '2024-11-06 14:00:00', NULL, '2024-11-06 14:05:00', 'VIEWED', 'Thông báo 6', 'SYSTEM'),
('Nội dung thông báo 7', '2024-11-07 15:00:00', NULL, '2024-11-07 15:05:00', 'NOT_SEEN', 'Thông báo 7', 'OTHER'),
('Nội dung thông báo 8', '2024-11-08 16:00:00', NULL, '2024-11-08 16:05:00', 'VIEWED', 'Thông báo 8', 'ORDER'),
('Nội dung thông báo 9', '2024-11-09 17:00:00', NULL, '2024-11-09 17:05:00', 'NOT_SEEN', 'Thông báo 9', 'SUPPORT'),
('Nội dung thông báo 10', '2024-11-10 18:00:00', NULL, '2024-11-10 18:05:00', 'VIEWED', 'Thông báo 10', 'SYSTEM'),
('Nội dung thông báo 11', '2024-11-11 19:00:00', NULL, '2024-11-11 19:05:00', 'NOT_SEEN', 'Thông báo 11', 'ORDER'),
('Nội dung thông báo 12', '2024-11-12 20:00:00', NULL, '2024-11-12 20:05:00', 'VIEWED', 'Thông báo 12', 'SUPPORT'),
('Nội dung thông báo 13', '2024-11-13 21:00:00', NULL, '2024-11-13 21:05:00', 'NOT_SEEN', 'Thông báo 13', 'SYSTEM'),
('Nội dung thông báo 14', '2024-11-14 22:00:00', NULL, '2024-11-14 22:05:00', 'VIEWED', 'Thông báo 14', 'OTHER'),
('Nội dung thông báo 15', '2024-11-15 23:00:00', NULL, '2024-11-15 23:05:00', 'NOT_SEEN', 'Thông báo 15', 'ORDER'),
('Nội dung thông báo 16', '2024-11-16 08:00:00', NULL, '2024-11-16 08:05:00', 'VIEWED', 'Thông báo 16', 'SUPPORT'),
('Nội dung thông báo 17', '2024-11-17 09:00:00', NULL, '2024-11-17 09:05:00', 'NOT_SEEN', 'Thông báo 17', 'SYSTEM'),
('Nội dung thông báo 18', '2024-11-18 10:00:00', NULL, '2024-11-18 10:05:00', 'VIEWED', 'Thông báo 18', 'ORDER'),
('Nội dung thông báo 19', '2024-11-19 11:00:00', NULL, '2024-11-19 11:05:00', 'NOT_SEEN', 'Thông báo 19', 'SUPPORT'),
('Nội dung thông báo 20', '2024-11-20 12:00:00', NULL, '2024-11-20 12:05:00', 'VIEWED', 'Thông báo 20', 'OTHER');

-- 16. Table Notification_Customer:
INSERT INTO customer_notification (customer_id, notification_id) VALUES
(4,1),
(4,4),
(4,7),
(4,8),
(4,11),
(5,14),
(5,15),
(5,18),
(5,20);

-- 17. Table Cart
INSERT INTO cart (customer_id) VALUES
(1),
(2),
(3),
(4),
(5),
(6),
(7),
(8),
(9),
(10),
(11),
(12),
(13),
(14),
(15);

-- 18. Table Order
INSERT INTO `order` (note, status, address_id, customer_id) VALUES
('Order note 1', 'COMPLETE_DELIVERY', 4, 1),
('Order note 2', 'CANCELED', 5, 2),
('Order note 3', 'COMPLETE_DELIVERY', 4, 1),
('Order note 4', 'CANCELED', 5, 2),
('Order note 5', 'COMPLETE_DELIVERY', 4, 1),
('Order note 6', 'CANCELED', 5, 2),
('Order note 7', 'COMPLETE_DELIVERY', 4, 1),
('Order note 8', 'CANCELED', 5, 2);

-- 19. Table Order Item
INSERT INTO order_item (quantity, book_id, cart_id, order_id) VALUES
-- Order 1: 2 items
(3, 1, 1, 1),
(2, 2, 1, 1),

-- Order 2: 1 item
(1, 3, 2, 2),

-- Order 3: 3 items
(4, 4, 1, 3),
(1, 5, 1, 3),
(2, 6, 1, 3),

-- Order 4: 2 items
(2, 7, 2, 4),
(5, 8, 2, 4),

-- Order 5: 4 items
(1, 9, 1, 5),
(2, 10, 1, 5),
(3, 1, 1, 5),
(4, 2, 1, 5),

-- Order 6: 1 item
(3, 3, 2, 6),

-- Order 7: 3 items
(2, 4, 1, 7),
(4, 5, 1, 7),
(1, 6, 1, 7),

-- Order 8: 2 items
(5, 7, 2, 8),
(3, 8, 2, 8);

-- 20. Table Bank Transfer
-- Bank transfer for Order 1 and 2
INSERT INTO bank_transfer (amount, created_at, currency, status, bank_account_number, bank_name, transaction_id, order_id) VALUES
(810000, '2024-11-01 10:30:00', 'VND', 'COMPLETED', '1234567890', 'Vietcombank', 'TRANS1', 1),
(170000, '2024-11-02 11:00:00', 'VND', 'COMPLETED', '0987654321', 'Techcombank', 'TRANS2', 2);

-- Table Cash
-- Cash payment for Order 3 and 4
INSERT INTO cash (amount, created_at, currency, status, cash_received, `change`, order_id) VALUES
(1430000, '2024-11-03 15:00:00', 'VND', 'COMPLETED', 1400000, 20000, 3),
(1230000, '2024-11-04 16:30:00', 'VND', 'COMPLETED', 800000, 50000, 4);

-- Table Credit Card
-- Credit card payment for Order 5 and 6
INSERT INTO credit_card (amount, created_at, currency, status, billing_address, card_holder_name, card_number, cvv, expiration_date, order_id) VALUES
(1650000, '2024-11-05 17:00:00', 'VND', 'COMPLETED', '123 Phan Xich Long, TP HCM', 'Nguyen Van A', '4111111111111111', '123', '2026-12-31 00:00:00', 5),
(510000, '2024-11-06 18:45:00', 'VND', 'COMPLETED', '456 Tran Hung Dao, TP HCM', 'Tran Thi B', '5555555555554444', '456', '2025-08-31 00:00:00', 6);

-- Table EWallet
-- Ewallet payment for Order 7
INSERT INTO ewallet (amount, created_at, currency, status, provider, transaction_id, wallet_id, order_id) VALUES
(1170000, '2024-11-07 09:30:00', 'VND', 'COMPLETED', 'MOMO', 'TXN1234567890', 'WALLET12345', 7),
(1270000, '2024-11-08 10:15:00', 'VND', 'COMPLETED', 'PAYPAL', 'TXN9876543210', 'WALLET67890', 8);
