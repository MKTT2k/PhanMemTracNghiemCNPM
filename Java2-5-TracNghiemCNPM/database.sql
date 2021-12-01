DROP database if exists QLTN ;
CREATE DATABASE QLTN;
USE QLTN;


-- Create a new table called '[CHAPTER] 'in schema '[dbo]'
-- Create the table in the specified schema
CREATE TABLE CHAPTER
(
  Chapter_Id INT PRIMARY KEY auto_increment, -- Primary Key column
  Chapter_Num INT NOT NULL, -- Number of Chapter
  Chapter_Name NVARCHAR(200) NOT NULL -- Name of Chapter
);


-- Create a new table called '[LEVEL] 'in schema '[dbo]'
-- Create the table in the specified schema
CREATE TABLE LEVEL
(
  Level_Id INT PRIMARY KEY auto_increment, -- Primary Key column
  Level_Name VARCHAR(10) NOT NULL -- Easy, Nomal, Hard
);


-- Create a new table called '[QUESTION] 'in schema '[dbo]'
-- Create the table in the specified schema
CREATE TABLE QUESTION
(
  Question_Id INT PRIMARY KEY auto_increment, -- Primary Key column
  Question_Content NVARCHAR(200) NOT NULL, -- Content
  Chapter_Id INT NOT NULL, 
  FOREIGN KEY (Chapter_Id) REFERENCES CHAPTER (Chapter_Id), -- The question belongs to which chapter
  Level_Id INT NOT NULL,
  FOREIGN KEY (Level_Id) REFERENCES LEVEL (Level_Id) -- Level of the question
);

-- Create a new table called '[ANSWER] 'in schema '[dbo]'
-- Create the table in the specified schema
CREATE TABLE ANSWER
(
  Answer_Id INT PRIMARY KEY auto_increment, -- Primary Key column
  Answer_Content NVARCHAR(200) NOT NULL DEFAULT N'Đây là câu trả lời sai!',
  Is_Correct BIT NOT NULL, -- 1 is Correct, 0 is Wrong
  Question_Id INT NOT NULL,
  FOREIGN KEY (Question_Id) REFERENCES QUESTION (Question_Id)
);

create table ACCOUNT(
	UserName char(10) primary key ,
    Password varchar(50) not null,
    Full_Name nvarchar(100) not null,
    Class_Name varchar(30) not null,
    Phone varchar(15) Not null,
    Role BIT not null default 0 -- 0 is student, 1 is teacher
);

CREATE TABLE Test(
	Test_Code NCHAR(20) PRIMARY KEY, -- mã đề
	Time INT default 20, -- Thời gian làm đề. 20p
	Level_Id INT NOT NULL, --  level test
    foreign key (Level_Id)references LEVEL (Level_Id),
	Status BIT DEFAULT 1 -- 1 : Đã được kích hoạt, 0 : Bị vô hiệu hóa
);

CREATE TABLE Test_Question(
	T_QT_ID INT PRIMARY KEY auto_increment,
	Test_Code NCHAR(20) NOT NULL,
    FOREIGN KEY (Test_Code) REFERENCES Test(Test_Code),
	Question_ID INT NOT NULL,
    FOREIGN KEY (Question_ID) REFERENCES Question(Question_ID)
);

CREATE TABLE RESULT
(
	Result_Id INT primary key auto_increment, -- Primary Key column
    Username char(10) NOT NULL,    -- user do test
    FOREIGN KEY (Username) REFERENCES ACCOUNT (Username),
    Test_Code NCHAR(20) NOT NULL,			-- test id
    foreign key (Test_Code) references TEST (Test_Code),
    WorkTime INT not null,  -- time to do this test = 20 - amount of time remaining;
    NumOfCorrect_Test INT not null, -- number of correct sentences 
    Date date not null
);



-- Insert rows into table 'CHAPTER 'in schema '[dbo]'
INSERT INTO CHAPTER (Chapter_Num, Chapter_Name)
VALUES(1, 'Tổng quan về công nghệ phần mềm'), -- ID 1
 (2, 'Phân tích và xác định yêu cầu') , -- ID 2
 (3, 'Thiết kế phần mềm') ,   -- ID 3
 (4, 'Kiểm thử phần mềm')    -- ID 4
;

-- Insert rows into table 'LEVEL 'in schema '[dbo]'
INSERT INTO LEVEL (Level_Name)
VALUES('Easy'), -- ID 1
 ('Nomal'),  -- ID 2
 ('Hard') -- ID 3
;

-- Insert rows into table 'QUESTION 'in schema '[dbo]'
INSERT INTO QUESTION (QUESTION_CONTENT, LEVEL_ID, CHAPTER_ID) 
	VALUES ('Tiêu chuẩn ISO-14598 đưa ra:', 1, 1);
INSERT INTO QUESTION (QUESTION_CONTENT, LEVEL_ID, CHAPTER_ID) 
	VALUES ('Trong phát triển phần mềm, yếu tố nào quan trọng nhất?', 2, 1);
INSERT INTO QUESTION (QUESTION_CONTENT, LEVEL_ID, CHAPTER_ID) 
	VALUES ('Kỹ thuật nào sau đây là xây dựng phần mềm từ các thành phần đã được thiết kế trong lĩnh vực công nghệ khác nhau?', 3,2);
INSERT INTO QUESTION (QUESTION_CONTENT, LEVEL_ID, CHAPTER_ID) 
	VALUES ('IEEE 830-1993 là một khuyến nghị tiêu chuẩn cho', 1, 2);
INSERT INTO QUESTION (QUESTION_CONTENT, LEVEL_ID, CHAPTER_ID) 
	VALUES ('Kỹ sư phần mềm không cần', 3, 1);
INSERT INTO QUESTION (QUESTION_CONTENT, LEVEL_ID, CHAPTER_ID) 
	VALUES ('Tính khả thi của phần mềm dựa vào các yếu tố sau', 2, 3);
INSERT INTO QUESTION (QUESTION_CONTENT, LEVEL_ID, CHAPTER_ID) 
	VALUES ('Phần mềm dự báo thời tiết thu thập các số liệu về nhiệt độ, độ ẩm, … xử lý tính toán để cho ra các dự báo thời tiết là 1 ví dụ của loại phần mềm', 1, 4);
INSERT INTO QUESTION (QUESTION_CONTENT, LEVEL_ID, CHAPTER_ID) 
	VALUES ('Loại phần mềm gì là 1 tập hợp các chương trình để cung cấp dịch vụ cho các chương trình khác', 2, 2);
INSERT INTO QUESTION (QUESTION_CONTENT, LEVEL_ID, CHAPTER_ID) 
	VALUES ('Phần mềm quản lý sinh viên của 1 trường là:', 3, 1);
INSERT INTO QUESTION (QUESTION_CONTENT, LEVEL_ID, CHAPTER_ID) 
	VALUES ('Phần mềm quản lý tài chính của một công ty là', 3, 3);
INSERT INTO QUESTION (QUESTION_CONTENT, LEVEL_ID, CHAPTER_ID) 
	VALUES ('Điều nào không đúng?', 2, 3);
INSERT INTO QUESTION (QUESTION_CONTENT, LEVEL_ID, CHAPTER_ID) 
	VALUES ('Mối quan tâm chính của công nghệ phần mềm là gì?', 1, 2);
INSERT INTO QUESTION (QUESTION_CONTENT, LEVEL_ID, CHAPTER_ID) 
	VALUES ('Điều nào là đặc trưng của một thiết kế phần mềm tốt?', 2, 1);
INSERT INTO QUESTION (QUESTION_CONTENT, LEVEL_ID, CHAPTER_ID) 
	VALUES ('Theo thống kê từ những thách thức đối với công nghệ phần mềm thì lỗi nhiều nhất làdo',1, 4);
INSERT INTO QUESTION (QUESTION_CONTENT, LEVEL_ID, CHAPTER_ID) 
	VALUES ('Yêu cầu có thể chia ra thành các lọai nào sau đây?',3, 3);
INSERT INTO QUESTION (QUESTION_CONTENT, LEVEL_ID, CHAPTER_ID) 
	VALUES ('2 hình thức dùng mô tả yêu cầu là:', 1, 2);
INSERT INTO QUESTION (QUESTION_CONTENT, LEVEL_ID, CHAPTER_ID) 
	VALUES ('Loại khả thi nào không được xem xét trong phân tích khả thi', 3, 2);
INSERT INTO QUESTION (QUESTION_CONTENT, LEVEL_ID, CHAPTER_ID) 
	VALUES ('Tính chất cần có của dữ liệu trong phân tích yêu cầu', 2, 3);
INSERT INTO QUESTION (QUESTION_CONTENT, LEVEL_ID, CHAPTER_ID) 
	VALUES ('Câu hỏi nào có liên quan đến phân tích thiết kế?', 1, 1);
INSERT INTO QUESTION (QUESTION_CONTENT, LEVEL_ID, CHAPTER_ID) 
	VALUES ('Tính chất nào không cần thiết cho phân tích dữ liệu ?', 3, 4);
INSERT INTO QUESTION (QUESTION_CONTENT, LEVEL_ID, CHAPTER_ID) 
	VALUES ('Phân tích yêu cầu bao gồm 3 hoạt động theo đúng thứ tự ?', 2, 1);
INSERT INTO QUESTION (QUESTION_CONTENT, LEVEL_ID, CHAPTER_ID) 
	VALUES ('Làm rõ yêu cầu (Eliciting requirements) là', 3, 3);
INSERT INTO QUESTION (QUESTION_CONTENT, LEVEL_ID, CHAPTER_ID) 
	VALUES ('Yêu cầu nào là yêu cầu chức năng?', 2, 3);
INSERT INTO QUESTION (QUESTION_CONTENT, LEVEL_ID, CHAPTER_ID) 
	VALUES ('SRS là viết tắt của:', 1, 2);
INSERT INTO QUESTION (QUESTION_CONTENT, LEVEL_ID, CHAPTER_ID) 
	VALUES ('Phát biểu nào sau đây là không đúng khi nói đến quá trình thu thập yêu cầu:', 2, 1);
INSERT INTO QUESTION (QUESTION_CONTENT, LEVEL_ID, CHAPTER_ID) 
	VALUES ('Có thể định nghĩa kỹ nghệ (Engineering) là:',1 ,1 );
INSERT INTO QUESTION (QUESTION_CONTENT, LEVEL_ID, CHAPTER_ID) 
	VALUES ('Một phần mềm được gọi là tốt nếu thoả mãn tối thiểu các thuộc tính:',3 ,1 );
INSERT INTO QUESTION (QUESTION_CONTENT, LEVEL_ID, CHAPTER_ID) 
	VALUES ('Thuộc tính có thể bảo trì được bao gồm các thành phần sau:',2 ,3 );
INSERT INTO QUESTION (QUESTION_CONTENT, LEVEL_ID, CHAPTER_ID) 
	VALUES ('Lỗi phần mềm "sai" được hiểu là:',3 ,3 );
INSERT INTO QUESTION (QUESTION_CONTENT, LEVEL_ID, CHAPTER_ID) 
	VALUES ('Nguyên nhân xuất hiện lỗi phần mềm đa số do:',1 ,1 );
INSERT INTO QUESTION (QUESTION_CONTENT, LEVEL_ID, CHAPTER_ID) 
	VALUES ('Định nghĩa kỹ nghệ phần mềm (Software Engineering)',1 ,2 );
INSERT INTO QUESTION (QUESTION_CONTENT, LEVEL_ID, CHAPTER_ID) 
	VALUES ('Quy trình làm phần mềm:',2,3 );
INSERT INTO QUESTION (QUESTION_CONTENT, LEVEL_ID, CHAPTER_ID) 
	VALUES ('Giai đoạn đặc tả và thiết kế chiếm khoảng bao nhiêu phần trăm (%) trong quá trình phát triển phần mềm?',3 ,3 );
INSERT INTO QUESTION (QUESTION_CONTENT, LEVEL_ID, CHAPTER_ID) 
	VALUES ('Trong quá trình phát triển phần mềm, giai đoạn nào quan trọng nhất?',3 ,4 );
INSERT INTO QUESTION (QUESTION_CONTENT, LEVEL_ID, CHAPTER_ID) 
	VALUES ('Giai đoạn lập trình chiếm khoảng bao nhiêu phần trăm (%) trong quá trình phát triển phần mềm?',2 ,3 );
INSERT INTO QUESTION (QUESTION_CONTENT, LEVEL_ID, CHAPTER_ID) 
	VALUES ('Câu hỏi không được kỹ sư phần mềm hiện nay quan tâm nữa:',1 ,4 );
INSERT INTO QUESTION (QUESTION_CONTENT, LEVEL_ID, CHAPTER_ID) 
	VALUES ('Ba giai đoạn tổng quát của công nghệ phần mềm :',3 ,1 );
INSERT INTO QUESTION (QUESTION_CONTENT, LEVEL_ID, CHAPTER_ID) 
	VALUES ('Mô hình phát triển ứng dụng nhanh:',1 ,3 );
INSERT INTO QUESTION (QUESTION_CONTENT, LEVEL_ID, CHAPTER_ID) 
	VALUES ('Mô hình tiến trình phần mềm tiến hóa:',2 ,3 );
INSERT INTO QUESTION (QUESTION_CONTENT, LEVEL_ID, CHAPTER_ID) 
	VALUES ('Mô hình phát triển phần mềm lặp lại tăng thêm :',3 ,3 );
INSERT INTO QUESTION (QUESTION_CONTENT, LEVEL_ID, CHAPTER_ID) 
	VALUES ('Mô hình phát triển phần mềm xoắn ốc :',2 ,3 );
INSERT INTO QUESTION (QUESTION_CONTENT, LEVEL_ID, CHAPTER_ID) 
	VALUES ('Mô hình phát triển dựa vào thành phần:',1 ,3 );
INSERT INTO QUESTION (QUESTION_CONTENT, LEVEL_ID, CHAPTER_ID) 
	VALUES ('Để xây dựng mô hình hệ thống, kỹ sư phải quan tâm tới một trong những nhân tố hạn chế sau :',1 ,3 );
INSERT INTO QUESTION (QUESTION_CONTENT, LEVEL_ID, CHAPTER_ID) 
	VALUES ('Trong kỹ thuật tiến trình nghiệp vụ, ba kiến trúc khác nhau được kiểm tra',3 ,4 );
INSERT INTO QUESTION (QUESTION_CONTENT, LEVEL_ID, CHAPTER_ID) 
	VALUES ('Thành phần nào của kỹ thuật tiến trình nghiệp vụ là trách nhiệm của kỹ sư phần mềm:',2 ,4 );
INSERT INTO QUESTION (QUESTION_CONTENT, LEVEL_ID, CHAPTER_ID) 
	VALUES ('Xác định yêu cầu phi chức năng", nghĩa là:',1 ,3 );
INSERT INTO QUESTION (QUESTION_CONTENT, LEVEL_ID, CHAPTER_ID) 
	VALUES ('Tạo nguyên mẫu giúp cho chi phí sửa lỗi giảm xuống, vì:',3 ,4 );
INSERT INTO QUESTION (QUESTION_CONTENT, LEVEL_ID, CHAPTER_ID) 
	VALUES ('Nếu phần mềm thoả mãn yêu cầu các chức năng không gây mâu thuẫn, có nghĩa phần mềm đã đáp ứng được nguyên tắc:',3 ,2 );
INSERT INTO QUESTION (QUESTION_CONTENT, LEVEL_ID, CHAPTER_ID) 
	VALUES ('Thẩm định là công việc chỉ được thực hiện sau:',1 ,2 );
INSERT INTO QUESTION (QUESTION_CONTENT, LEVEL_ID, CHAPTER_ID) 
	VALUES ('Trong thiết kế phần mềm, giai đoạn thiết kế kiến trúc là:',2 ,3 );


-- Insert rows into table 'ANSWER 'in schema '[dbo]'
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Đưa ra quy trình đánh giá tính an toàn cho sản phẩm phần mềm.', FALSE, 1);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Đưa ra quy trình đánh giá hiệu quả của phần mềm.', FALSE, 1);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Đưa ra quy trình đánh giá chất lượng cho sản phẩm phần mềm.', TRUE, 1);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Đưa ra quy trình đánh giá tính khả dụng cho sản phẩm phần mềm.', FALSE, 1);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Con người', TRUE, 2);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Quy trình', FALSE, 2);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Sản phẩm', FALSE, 2);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Thời gian', FALSE, 2);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Extreme programming', FALSE, 3);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Evolutionary prototyping', FALSE, 3);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Component architecture', TRUE, 3);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Open-source development', FALSE, 3);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Software requirement specification', TRUE, 4);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Software design.', FALSE, 4);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Testing.', FALSE, 4);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Coding.', FALSE, 4);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Kiến thức về phân tích thiết kế hệ thống.', FALSE, 5);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Kiến thức về cơ sở dữ liệu.', FALSE, 5);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Lập trình thành thạo bằng một ngôn ngữ lập trình.', TRUE, 5);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Kinh nghiệm quản lý dự án phần mềm. ', FALSE, 5);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Nghiệp vụ và tiếp thị.', FALSE, 6);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Phạm vi, ràng buộc và thị trường.', FALSE, 6);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Công nghệ, tiền bạc, thời gian và tài nguyên.', TRUE, 6);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Kỹ năng và năng lực của nhà phát triển.', FALSE, 6);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Phần mềm hệ thống (System software)', FALSE, 7);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Phần mềm trí tuệ nhân tạo (Artificial Intelligence Software)', FALSE, 7);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Phần mềm thời gian thực (Real time software) ', TRUE, 7);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Phần mềm nghiệp vụ (Business software)', FALSE, 7);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Phần mềm hệ thống (System software)', FALSE, 8);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Phần mềm trí tuệ nhân tạo (Artificial Intelligence Software)', FALSE, 8);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Phần mềm thời gian thực (Real time software)', TRUE, 8);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Phần mềm nghiệp vụ (Business software)', FALSE, 8);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Phần mềm hệ thống (System software)', FALSE, 9);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Phần mềm trí tuệ nhân tạo (Artificial Intelligence Software)', FALSE, 9);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Phần mềm thời gian thực (Real time software) ', FALSE, 9);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Phần mềm nghiệp vụ (Business software) ', TRUE, 9);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Phần mềm hệ thống (System software)', FALSE, 10);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Phần mềm trí tuệ nhân tạo (Artificial Intelligence Software)', FALSE, 10);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Phần mềm thời gian thực (Real time software) ', FALSE, 10);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Phần mềm nghiệp vụ (Business software) ', TRUE, 10);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Công nghệ phần mềm thuộc ngành khoa học máy tính.', FALSE, 11);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Công nghệ phần mềm là một phần của ngành kỹ thuật hệ thống (System Engineering).', FALSE, 11);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Khoa học máy tính thuộc ngành công nghệ phần mềm. ', TRUE, 11);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Công nghệ phần mềm có liên quan với việc phát triển và cung cấp các phần mềm hữu ích', FALSE, 11);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('.Sản xuất phần cứng.', FALSE, 12);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Sản xuất phần mềm.', TRUE, 12);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Cấu hình mạng.', FALSE, 12);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Phần mềm có thể dùng lại.', FALSE, 12);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Thể hiện kết nối mạnh mẽ giữa các mô-đun của nó.', FALSE, 13);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Thực hiện tất cả các yêu cầu trong mô hình phân tích.', TRUE, 13);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Bao gồm các trường hợp thử nghiệm cho tất cả các thành phần', FALSE, 13);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Cung cấp một bức tranh hoàn chỉnh của phần mềm.', FALSE, 13);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Kiểm tra và bảo trì', FALSE, 14);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Phân tích yêu cầu', TRUE, 14);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Thiết kế', FALSE, 14);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Viết Code', FALSE, 14);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Chức năng, phi chức năng, yêu cầu hệ thống.', FALSE, 15);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Chức năng, phi chức năng ', TRUE, 15);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Chức năng, phi chức năng, yêu cầu miền ứng dụng.', FALSE, 15);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Chức năng, phi chức năng, yêu cầu nghiệp vụ.', FALSE, 15);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Yêu cầu người dùng và yêu cầu hệ thống.', TRUE, 16);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Yêu cầu chức năng và yêu cầu phi chức năng.', FALSE, 16);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Yêu cầu chủ động và yêu cầu thụ động.', FALSE, 16);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Yêu cầu cụ thể và yêu cầu trừu tượng.', FALSE, 16);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Khả thi về kinh tế.', FALSE, 17);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Khả thi về thực hiện.', FALSE, 17);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Khả thi vể kỹ thuật.', FALSE, 17);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Khả thi về chất lượng.', TRUE, 17);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Có định hướng thời gian.', TRUE, 18);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Có giá trị pháp lý.', FALSE, 18);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Tính mô tả trừu tượng', FALSE, 18);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Có thể mô tả bằng toán học.', FALSE, 18);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Thời gian hoàn thành dự án có đủ không?', FALSE, 19);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Làm thế nào chuyển thiết kế dữ liệu logic sang thiết kế dữ liệu vật lý?', TRUE, 19);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Các xử lý nào được tiến hành và các thông tin chi tiết liên quan?', FALSE, 19);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Đâu là phạm vi của hệ thống phần mềm?', FALSE, 19);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Cấu trúc dữ liệu.', FALSE, 20);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Đầy đủ.', FALSE, 20);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Bảo mật.', TRUE, 20);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Độ lớn. ', FALSE, 20);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Làm tài liệu yêu cầu, làm rõ yêu cầu, xem xét yêu cầu. ', FALSE, 21);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Làm rõ yêu cầu, xem xét yêu cầu, làm tài liệu yêu cầu.  ', TRUE, 21);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Xem xét yêu cầu, làm tài liệu yêu cầu, làm rõ yêu cầu. ', FALSE, 21);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Làm rõ yêu cầu, làm tài liệu yêu cầu, xem xét yêu cầu. ', FALSE, 21);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Giao tiếp với khách hàng và người sử dụng để xác định các yêu cầu củahọ.', TRUE, 22);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Các yêu cầu được ghi nhận lại theo nhiều hình thức.', FALSE, 22);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Các yêu cầu được tổng hợp lại theo nhiều hình thức.', FALSE, 22);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Xem các yêu cầu có ở tình trạng không rõ ràng', FALSE, 22);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Cảnh báo người dùng khi dung lượng trống trên đĩa còn 20%.', FALSE, 23);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Thực hiện thao tác thêm, xem, xóa, sửa dữ liệu nghiệp vụ. ', TRUE, 23);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Cảnh báo ngày hệ thống bị sai.', FALSE, 23);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Yêu cầu chỉnh lại ngày giờ hệ thống mỗi khi làm việc.', FALSE, 23);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Software Requirement Specification. ', TRUE, 24);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('System Requirement Specification.', FALSE, 24);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Studying Requirement Specification.', FALSE, 24);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Solve Requirement Specification.', FALSE, 24);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Yêu cầu rất khó phát hiện.', FALSE, 25);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Yêu cầu rất dễ bị thay đổi.', FALSE, 25);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Yêu cầu phải luôn thống nhất.', FALSE, 25);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Yêu cầu luôn được biết một cách chính xác.', TRUE, 25);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Tập hợp các công nghệ được bố trí theo một quy trình nhất định.', FALSE, 26);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Dùng các công cụ để tạo ra các sản phẩm nhất định', FALSE, 26);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Là một cách thức tiến hành một công việc để tạo ra một sản phẩm của một ngành nào đó.', FALSE, 26);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Là việc sử dụng phối hợp các công nghệ cần thiết để sản xuất ra các sản phẩm của một ngành nào đó.', TRUE, 26);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Đáng tin cậy, có hiệu quả, giao diện người sử dụng thích hợp, có thể bảo trì được, dễ sửa lỗi.', FALSE, 27);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Phần mềm thoả mãn yêu cầu người dùng, có hiệu quả, giao diện người sử dụng thích hợp, có thể bảo trì được, giá cả chấp nhận được.', FALSE, 27);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Đáng tin cậy, có hiệu quả, tính bảo mật cao, có thể bảo trì được, dễ sửa lỗi.', FALSE, 27);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Đáng tin cậy, có hiệu quả, giao diện người sử dụng thích hợp, có thể bảo trì được, giá cả phải chấp nhận được', TRUE, 27);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Dễ sửa lỗi, nâng cấp.', FALSE, 28);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Dễ sửa lỗi, nâng cấp và chuyển giao công nghệ.', FALSE, 28);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Có đầy đủ tài liệu và việc thay đổi có thể thực hiện mà không quá tốn kém.', TRUE, 28);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Dễ sửa lỗi, có đầy đủ tài liệu để nâng cấp phần mềm.', FALSE, 28);
 INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Sản phẩm được xây dựng khác với đặc tả.', TRUE, 29);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Lập trình được xây dựng khác với thiết kế.', FALSE, 29);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Thiết kế được xây dựng khác với lập trình.', FALSE, 29);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Sản phẩm được xây dựng khác với chương trình.', FALSE, 29);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Kiểm định.', FALSE, 30);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Đặc tả.', TRUE, 30);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Thiết kế.', FALSE, 30);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Lập trình.', FALSE, 30);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Kỹ nghệ phần mềm là sự áp dụng có hệ thống các kiến thức kỹ nghệ vào phần mềm', FALSE, 31);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Kỹ nghệ phần mềm là sự áp dụng các ứng dụng thực tế vào phần mềm', FALSE, 31);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Kỹ nghệ phần mềm là sự áp dụng có hệ thống các phương pháp vào các khâu phát triển của phần mềm', TRUE, 31);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Kỹ nghệ phần mềm làc sự áp dụng các kỹ năng và phương pháp vào phần mềm', FALSE, 31);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Đặc tả, thiết kế, lập trình, kiểm định, bảo trì.', TRUE, 32);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Đặc tả, thiết kế, tạo mã, lập trình, kiểm định.', FALSE, 32);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Giai đoạn thiết kế và lập trình.', FALSE, 32);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Giai đoạn lập trình.', FALSE, 32);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('20%', FALSE, 33);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('25%', FALSE, 33);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('30%', FALSE, 33);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('45%', TRUE, 33);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Giai đoạn thiết kế và lập trình.', FALSE, 34);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Giai đoạn lập trình.', FALSE, 34);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Giai đoạn lập kiểm định và bảo hành.', FALSE, 34);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Giai đoạn đặc tả và thiết kế.', TRUE, 34);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('20%', TRUE, 35);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('25%', FALSE, 35);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('30%', FALSE, 35);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('40%', FALSE, 35);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Tại sao chi phí phần cứng máy tính quá cao?', TRUE, 36);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Tại sao phần mềm mất một thời gian dài để hoàn tất?', FALSE, 36);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Tại sao người ta tốn nhiếu chi phí để phát triển một mẩu phần mềm?', FALSE, 36);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Tại sao những lỗi phần mềm không được loại bỏ trong sản phẩm trước khi xuất xưởng', FALSE, 36);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Definition, development, support', TRUE, 37);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('What, how, where', FALSE, 37);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Programming, debugging, maintenance', FALSE, 37);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Analysis, design, testing', FALSE, 37);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Một cách gọi khác của mô hình phát triển dựa vào thành phần', FALSE, 38);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Một cách hữu dụng khi khách hàng không xàc định yêu cầu rõ ràng', FALSE, 38);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Sự ráp nối tốc độ cao của mô hình tuần tự tuyến tính', TRUE, 38);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Tất cả mục trên', FALSE, 38);
 INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Bản chất lặp', FALSE, 39);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Dễ dàng điều tiết những biến đổi yêu cầu sản phẩm', FALSE, 39);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Nói chung không tạo ra những sản phẩm bỏ đi', FALSE, 39);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Tất cả các mục', TRUE, 39);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Một hướng hợp lý khi yêu cầu được xác định rõ', FALSE, 40);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Một hướng tốt khi cần tạo nhanh một sản phẩm thực thi lõi', TRUE, 40);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Một hướng tốt nhất dùng cho những dự án có những nhóm phát triển lớn', FALSE, 40);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Một mô hình cách mạng không nhưng không được dùng cho sản phẩm thương mại', FALSE, 40);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Kết thúc với việc xuất xưởng sản phẩm phần mềm', FALSE, 41);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Nhiều hỗn độn hơn với mô hình gia tăng', FALSE, 41);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Bao gồm việc đánh giá những rủi ro phần mềm trong mỗi vòng lặp', TRUE, 41);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Tất cả điều trên', FALSE, 41);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Chỉ phù hợp cho thiết kế phần cứng máy tính', FALSE, 42);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Không thể hỗ trợ phát triển những thành phần sử dụng lại', FALSE, 42);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Dựa vào những kỹ thuật hỗ trợ đối tượng', TRUE, 42);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Không định chi phí hiệu quả bằng những độ đo phần mềm có thể định lượng', FALSE, 42);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Những giả định và những ràng buộc', TRUE, 43);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Ngân sách và phí tổn', FALSE, 43);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Những đối tượng và những hoạt động', FALSE, 43);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Lịch biểu và các mốc sự kiện', FALSE, 43);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Hạ tầng kỹ thuật, dữ liệu, ứng dụng', TRUE, 44);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Hạ tầng tài chánh, tổ chức và truyền thông', FALSE, 44);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Cấu trúc báo cáo, cơ sở dữ liệu, mạng', FALSE, 44);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Cấu trúc dữ liệu, yêu cầu, hệ thống', FALSE, 44);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Phân tích phạm vi nghiệp vụ', FALSE, 45);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Thiết kế hệ thống nghiệp vụ', TRUE, 45);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Kế hoạch sản phẩm', FALSE, 45);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Kế hoạch chiến lược thông tin', FALSE, 45);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Đặc tả các yêu cầu của người dùng.', FALSE, 46);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Đặc tả trìu tượng các nhu cầu của người dùng mà hệ thống phải cung cấp.', FALSE, 46);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Đặc tả trìu tượng các dịch vụ mà hệ thống phải cung cấp', FALSE, 46);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Đặc tả trìu tượng các ràng buộc mà hệ thống phải tuân theo.', TRUE, 46);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Nếu có bản nguyên mẫu, thì phần mềm không cần phải bảo trì.', FALSE, 47);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Nếu khách hàng chấp nhận nguyên mẫu, thì khách hàng cũng chấp nhận phần mềm chính thức. Nên không mất chi phí sửa lỗi.', FALSE, 47);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Tạo nguyên mẫu cho phép phát hiện sớm các lỗi, giúp cho việc sửa chữa diễn ra vào thời kỳ đầu của quá trình phát triển phần mềm. Vì vậy chi phí bảo trì giảm.', TRUE, 47);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Tạo nguyên mẫu dùng làm tài liệu cho người sử dụng, vì vậy không tốn kém tiền đào tạo.', FALSE, 47);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Đầy đủ', FALSE, 48);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Tráng kiện', TRUE, 48);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Hợp lý', FALSE, 48);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Không mâu thuẫn', FALSE, 48);
 INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Giai đoạn đặc tả', FALSE, 49);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Giai đoạn thiết kế và lập trình', FALSE, 49);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Các giai đoạn phát triển phần mềm như: đặc tả, thiết kế, lập trình.', FALSE, 49);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Tất cả các giai đoạn phát triển phần mềm như: đặc tả, thiết kế, lập trình.', TRUE, 49);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Các kiến trúc dữ liệu được dùng trong việc thực hiện hệ thống được thiết kế chi tiết và được đặc tả.', FALSE, 50);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Các hệ con tạo nên hệ tổng thể và các quan hệ của chúng là được minh định và ghi thành tài liệu.', FALSE, 50);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Các dịch vụ cung cấp bởi một hệ con được phân chia qua các thành phần của hệ con đó.', TRUE, 50);
INSERT INTO ANSWER (ANSWER_CONTENT, IS_CORRECT, QUESTION_ID) 
	VALUES ('Đối với các hệ con, đặc tả các dịch vụ mà nó phải cung cấp và các ràng buộc mà nó phải tuân theo.', FALSE, 50);

INSERT INTO ACCOUNT
VALUES ('2018601682','123456','Hà Thanh Hoàng','GVCN1','0394546187', 1);    
INSERT INTO ACCOUNT
VALUES ('2018601498','123456','La Văn Hòa','GVCN22','0358939200', 1);
INSERT INTO ACCOUNT
VALUES ('2018601593','123456','Nguyễn Đức Hòa','CNTT1','0384791470', 0);
INSERT INTO ACCOUNT
VALUES ('2018601042','123456','Nguyễn Đức An','CNTT2','0183467372', 0);
INSERT INTO ACCOUNT
VALUES ('2018601880','123456','Tống Cao Cường','CNTT3','0281957364', 0);
INSERT INTO ACCOUNT
VALUES ('2018601788','123456','Nguyễn Anh Đức','CNTT2','0291837463', 0);
INSERT INTO ACCOUNT
VALUES ('2018601096','123456','Vũ Trường Giang','CNTT1','0684759323', 0);

-- Insert rows into table Test
-- INSERT INTO Test (Test_Code, Level_Id, Status)
-- VALUES('DH131', 1, 1);
-- INSERT INTO Test (Test_Code, Level_Id, Status)
-- VALUES('TH215', 3, 1);
-- INSERT INTO Test (Test_Code, Level_Id, Status)
-- VALUES('TH089', 1, 1);
-- INSERT INTO Test (Test_Code, Level_Id, Status)
-- VALUES('HP286', 2, 1);
-- INSERT INTO Test (Test_Code, Level_Id, Status)
-- VALUES('VH222', 3, 1);

-- Insert rows into table Test_Question
-- INSERT INTO Test_Question(Test_Code, Question_ID)
-- VALUES ('DH131',1);
-- INSERT INTO Test_Question(Test_Code, Question_ID)
-- VALUES ('DH131',2);
-- INSERT INTO Test_Question(Test_Code, Question_ID)
-- VALUES ('DH131',3);
-- INSERT INTO Test_Question(Test_Code, Question_ID)
-- VALUES ('TH215',1);
-- INSERT INTO Test_Question(Test_Code, Question_ID)
-- VALUES ('TH215',3);

-- INSERT INTO RESULT (Username, Test_Code, WorkTime, NumOfCorrect_Test, Date)
-- VALUES ('8764556797', 'TH215', 19, 20, '2021-05-03');
-- INSERT INTO RESULT (Username, Test_Code, WorkTime, NumOfCorrect_Test, Date)
-- VALUES ('8764556797', 'DH131', 10, 15, '2021-05-01');
-- INSERT INTO RESULT (Username, Test_Code, WorkTime, NumOfCorrect_Test, Date)
-- VALUES ('2018601498', 'DH131', 18, 18, '2021-05-03');
-- INSERT INTO RESULT (Username, Test_Code, WorkTime, NumOfCorrect_Test, Date)
-- VALUES ('1234562345', 'DH131', 20, 17, '2021-05-03');

select * from result group by Test_code order by Result_Id ;


SELECT * FROM LEVEL;
SELECT * FROM CHAPTER;
SELECT COUNT(*) FROM QUESTION where level_id = 3;
SELECT COUNT(*) FROM ANSWER;
select * from test;
select * from test_question;
select * from account;
select username,  test_code, NumOfCorrect_Test*0.4 as Diem;
select * from result
where test_code = 'DH131';
select question.question_content, answer_content, is_correct from question inner join answer on question.question_id = answer.question_id

