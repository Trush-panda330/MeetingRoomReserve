package mrs.domain.model;

import java.io.Serializable;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity // このクラスがデータベースのエンティティ（テーブル）であることを示す
@Data // Lombokを使用してゲッター、セッター、toStringメソッドを自動生成する
public class Reservation implements Serializable {

    @Id // 主キーを示す
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 主キーの自動生成戦略を指定
    private Integer reservationId; // 予約ID

    private LocalTime startTime; // 開始時間

    private LocalTime endTime; // 終了時間

    @ManyToOne // 多対一のリレーションを定義
    @JoinColumns({ 
        @JoinColumn(name = "reserved_date"), // 複合外部キーの1つ
        @JoinColumn(name = "room_id") // 複合外部キーの2つ目
    })
    private ReservableRoom reservableRoom; // 予約可能な部屋とのリレーション

    @ManyToOne // 多対一のリレーションを定義
    @JoinColumn(name = "user_id") // 外部キーであるuser_idを指定
    private User user; // ユーザーとのリレーション

}
