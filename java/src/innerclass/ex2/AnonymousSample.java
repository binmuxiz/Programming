package innerclass.ex2;

public class AnonymousSample {
    public static void main(String[] args) {
        AnonymousSample sample = new AnonymousSample();
        sample.setButtonListener();
        sample.setButtonListenerAnonymous();
    }

    private void setButtonListener() {
        MagicButton button = new MagicButton();
        button.setListener(new MagicButtonListener());
        button.onClickProcess();
    }

    private void setButtonListenerAnonymous() {
        MagicButton button = new MagicButton();
        button.setListener(new EventListener() {
            @Override
            public void onClick() {
                System.out.println("Magic Button Anonymous click!!!");
            }
        });
        button.onClickProcess();
    }
}
