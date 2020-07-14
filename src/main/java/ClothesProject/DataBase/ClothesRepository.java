package ClothesProject.DataBase;

import ClothesProject.Clothes;

public class ClothesRepository extends BaseRepository<Clothes> {

    public ClothesRepository(ConnectionManager manager, RowMapper<Clothes> clothesRowMapper) {
        super(manager, clothesRowMapper);
    }

    @Override
    protected String getTableName() {
        return "complex_clothes";
    }
}
