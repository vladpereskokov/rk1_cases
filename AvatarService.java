import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
/**
 * Переписать функции create, changeName и addPerk на Reflection. Т.е. все вызовы и все операции создания объектов (кроме NullPointerException) 
 * в этих методах должны быть сделаны через Reflection
 */
public class AvatarService {
    private Map<Long, Avatar> avatars;

    public static final class Avatar {
        private final static AtomicLong ID_GEN = new AtomicLong(0);

        private final Long id;
        private String name;
        private List<Object> perks;

        //serialization constructor
        public Avatar() {
            id = ID_GEN.getAndIncrement();
        }

        public Avatar(String name, List<Object> perks) {
            id = ID_GEN.getAndIncrement();
            this.name = name;
            this.perks = perks;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Object> getPerks() {
            return perks;
        }
    }

    public Avatar create(String name, List<Object> perks) {
        Avatar avatar = new Avatar(name, perks);
        avatars.put(avatar.id, avatar);
        return avatar;
    }

    public void changeName(long id, String newName) {
        Avatar avatar = avatars.get(id);
        if (avatar == null)
            throw new NullPointerException("No avatar with id = " + id + " found");
        avatar.setName(newName);
    }

    public void addPerk(long id, Object perk) {
        Avatar avatar = avatars.get(id);
        if (avatar == null)
            throw new NullPointerException("No avatar with id = " + id + " found");
        avatar.getPerks().add(perk);
    }
}