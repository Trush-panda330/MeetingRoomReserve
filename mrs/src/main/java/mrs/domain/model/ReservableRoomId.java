package mrs.domain.model;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor 
@AllArgsConstructor 
@Embeddable // このクラスがエンティティの一部（埋め込み型）として扱われることを示すJPAのアノテーション
@Data // ゲッター、セッター、equals、hashCode、toStringメソッドを自動生成
public class ReservableRoomId implements Serializable { 
	
    // カラム名を指定して、room_idカラムにマッピングすることを示すJPAのアノテーション
    @Column(name = "room_id")
    private Integer roomId; // 会議室のID（主キーの一部）

    // カラム名を指定して、reserved_dateカラムにマッピングすることを示すJPAのアノテーション
    @Column(name = "reserved_date")
    private LocalDate reservedDate; // 予約日（主キーの一部）

    // 引数なしのコンストラクタを自動生成するLombokの@NoArgsConstructorがあるため、明示的な定義は不要
    // 全てのフィールドを引数に持つコンストラクタもLombokの@AllArgsConstructorがあるため不要

    // equalsやhashCodeメソッドもLombokの@Dataが自動生成するため、手動での定義は不要
    // これにより、比較やハッシュ値の計算がフィールドに基づいて適切に行われる

}
