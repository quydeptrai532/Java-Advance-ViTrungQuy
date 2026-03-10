package btth;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {

    // Lọc user đã xác thực
    public List<User> getVerifiedUsers(List<User> users) {
        return users.stream()
                .filter(User::isVerified)
                .collect(Collectors.toList());
    }

    // Phân loại tier
    public Tier classifyTier(long months) {

        return switch ((int) months) {
            default -> {
                if (months > 24) yield new Gold();
                else if (months > 12) yield new Silver();
                else yield new Bronze();
            }
        };
    }

    // chuyển User -> PublicUser
    public PublicUser toPublicUser(User user) {

        long months = Period.between(user.getCreatedAt(), LocalDate.now()).toTotalMonths();

        Tier tier = classifyTier(months);

        return new PublicUser(user.getId(), user.getEmail(), tier);
    }
}