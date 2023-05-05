import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyJComponent extends JComponent implements ActionListener {
    private static MyJComponent myJComponent = null;
    public static MyJComponent getMyJComponent() {
        return myJComponent;
    }
    public static void add(MyJComponent component)
    {
        component.SetComponent(myJComponent);
        myJComponent = component;
    }
    protected void SetComponent(JComponent component)
    {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
