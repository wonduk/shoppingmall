package org.shppoingmall.shopping.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="item")
@Getter
@Setter
@ToString
public class Item {
    
    @Id
    @Column(name="item_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; //상품코드
    
    @Column(nullable = false, length = 50)
    private String itemNm; // 상품명
    
    @Column(nullable = false, name = "price")
    private int price; //가격
    
    @Column(nullable = false)
    private int stockNumber; // 재고수량
    
    @Lob
    @Column(nullable = false)
    private String itemDetail; //제품 상세 설명

    @Enumerated(EnumType.STRING) //ItemSellStatus.java의 상수들을 가져옴
    private ItemSellStatus itemSellStatus; // 상품 판매 상태

    private LocalDateTime regTime; //등록시간

    private LocalDateTime updateTime; // 수정시간


}
