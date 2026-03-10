package btth;

public record PublicUser<Tier>(String id, String email, Tier tier) {}