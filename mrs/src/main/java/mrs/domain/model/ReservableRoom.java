package mrs.domain.model;

import java.io.Serializable;

import jakarta.persistence.EmbeddedId; // 組み込みID（複合キー）を定義するためのアノテーション
import jakarta.persistence.Entity; // このクラスをデータベースのエンティティ（テーブル）として扱うためのアノテーション
import jakarta.persistence.JoinColumn; // 外部キーの結合カラムを指定するアノテーション
import jakarta.persistence.ManyToOne; // 多対一のリレーションを定義するためのアノテーション
import jakarta.persistence.MapsId; // 複合キーを使用して親エンティティとマップするためのアノテーション
import lombok.AllArgsConstructor;
import lombok.Data; // ゲッター、セッター、toString、equals、hashCodeなどを自動生成するためのアノテーション
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data // Lombokを使って自動的にゲッター、セッター、toStringメソッドを生成する
public class ReservableRoom implements Serializable{ // `ReservationRoom` エンティティはデータベースで予約可能な部屋を表す

    @EmbeddedId // 複合主キーとして `ReservableRoomId` クラスを使用する
    private ReservableRoomId reservableRoomId; // `ReservableRoomId` は、予約可能な部屋を一意に識別する複合主キー

    @ManyToOne // 多対一のリレーションを定義。複数の予約可能な部屋が1つの会議室に対応する
    
 // 外部キーである `room_id` を使用して `MeetingRoom` に結合。外部キーは更新も挿入もできない
    @JoinColumn(name = "room_id" , insertable = false, updatable = false) 
    
 // `ReservableRoomId` の `roomId` をこのエンティティの `room_id` にマッピングする
    @MapsId("roomId") 
    private MeetingRoom meetingRoom; // 会議室（`MeetingRoom` エンティティ）とのリレーション

  

}
