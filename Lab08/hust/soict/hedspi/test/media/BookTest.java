package hust.soict.hedspi.test.media;

import hust.soict.hedspi.aims.media.Book;

public class BookTest {
    public static void main(String[] args){
        Book b = new Book(1,"Tat den","Truyen ngan",40.32f);
        b.setContent("Bắt đầu từ gà gáy một tiếng, trâu bò lục-tục kéo thợ cầy đến đoạn đường phía trong điếm tuần.\n" +
                "\n" +
                "Mọi ngày, giờ ấy, những con-vật này cũng như những người cổ cầy, vai bừa kia, đã lần-lượt đi mò ra ruộng làm việc cho chủ. Hôm nay, vì cổng làng chưa mở, chúng phải chia quãng đứng rải-rác ở hai vệ đường, giống như một lũ phu vờ chờ đón những ông quan lớn.\n" +
                "\n" +
                "Dưới bóng tối của rặng tre um-tùm, tiếng trâu thở hì-hò, tiếng bò đập đuôi đen- đét, sen với tiếng người khạc khúng-khắng.\n" +
                "\n" +
                "Cảnh-tượng điếm tuần thình-lình hiện ra trong ánh lửa lập-lòe của chiếc mồi rơm bị thổi. Cạnh giẫy sào, giáo ngả nghiêng dựng ở giáp tường, một lũ tuần-phu lố-nhố ngồi trên lớp chiếu quằn-quèo. Có người phì-phò thổi mồi. Có người ve-ve mồi thuốc và chìa tay chờ đón điếu đóm. Có người há miệng ngáp dài. Có người đang hai tay dụi mắt. Cũng có người gối đầu trên cái miệng hiệu sừng trâu, ngảnh mặt vào vách mà ngáy.\n" +
                "\n" +
                "Cái điếu cày và cái đóm lửa bị năm, sáu người chuyền tay, chiếu đi, chiếu lại độ vài ba vòng, ánh lửa lại tắt, trong điếm chỉ còn tiếng nói chuyện rầm-rầm.\n" +
                "\n" +
                "Gà gáy giục. Trời sáng mờ-mờ.\n" +
                "\n" +
                "Trâu bò, con đứng, con nằm, thi nhau quai hai hàm răng nhai trầu xuông và nhả ra những cục nước bọt to bằng cái trứng.\n" +
                "\n" +
                "Thợ cầy khắp lượt dùng bắp cầy, vai cầy làm ghế ngồi, cùng nhau bàn tán băng-cua về chuyện sưu thuế.\n" +
                "\n" +
                "Những con chèo-bẻo chẽo-choẹt hót trên ngọn tre, như muốn họa lại khúc ca réo-rắt - mà người quê vẫn gọi là khúc váy cô, cô cởí - của mấy con chào-mào đậu trên cành xoan, đon- đả chào vẻ tươi đẹp của cảnh trời buổi sáng.\n" +
                "\n" +
                "Toang cổng vẫn đóng chặt. Tuần-phu lại lần lượt thổi mồi hút thuốc lào.\n" +
                "\n" +
                "- Ông Trương ơi, ông làm ơn mở cổng cho tôi đánh trâu ra đồng ạ. Mọi ngày bây giờ tôi đã cầy được ba sào ruộng rồi. Hôm nay, bây giờ còn nhong-nhóng ở đây... Phỏng chừng từ giờ đến trưa, cầy sao cho xong cái ruộng mẫu hai? Thôi ông làm phúc, làm đức...");
        System.out.println(b.toString());
    }
}
