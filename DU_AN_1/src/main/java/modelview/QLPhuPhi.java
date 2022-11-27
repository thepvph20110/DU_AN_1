package modelview;

import enumclass.trangThaiPhuPhi;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QLPhuPhi {

    private UUID id;

    private String maPhuPhi;

    private String tenPhuPhi;
<<<<<<< HEAD

    private double giaPhuPhi;

    private String moTa;

    private trangThaiPhuPhi trangThai = trangThaiPhuPhi.Co;

    public QLPhuPhi(UUID id) {
        this.id = id;
    }
    
    
=======
>>>>>>> 0f4cad2f7c54da986d78447c8a91cf878af78d91
}
