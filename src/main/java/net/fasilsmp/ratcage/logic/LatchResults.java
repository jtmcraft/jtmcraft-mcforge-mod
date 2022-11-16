package net.fasilsmp.ratcage.logic;

public class LatchResults {
    private boolean powered;
    private boolean sendUpdate;

    public LatchResults(boolean powered, boolean sendUpdate) {
        this.powered = powered;
        this.sendUpdate = sendUpdate;
    }

    public boolean isPowered() {
        return powered;
    }

    public void setPowered(boolean powered) {
        this.powered = powered;
    }

    public boolean isSendUpdate() {
        return sendUpdate;
    }

    public void setSendUpdate(boolean sendUpdate) {
        this.sendUpdate = sendUpdate;
    }
}
