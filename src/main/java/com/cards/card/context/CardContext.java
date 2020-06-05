package com.cards.card.context;

public final class CardContext {

    private static final ThreadLocal<String> USER_ID_CONTEXT = new InheritableThreadLocal<>();

    public static void setUserId(String userId) {
        USER_ID_CONTEXT.set(userId);
    }

    public static String getUserId() {
        return USER_ID_CONTEXT.get();
    }

    public static void clear() {
        USER_ID_CONTEXT.remove();
    }

}
