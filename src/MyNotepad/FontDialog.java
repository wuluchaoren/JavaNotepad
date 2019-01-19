package MyNotepad;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;


//�����塱�Ի���
public class FontDialog extends JDialog {
    //��ȡϵͳ����
    private String[] font = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    //�����б��
    private JList fontList = new JList(font);
    private JTextField fontText = new JTextField(10);
    //����
    public static final String[] fontStyle = {"����", "����", "��б", "��ƫб��"}; //��Ӧ�����γ���ֵ�ֱ�Ϊ0, 1, 2, 3
    private JList fontStyleList = new JList(fontStyle);
    private JTextField fontStyleText = new JTextField(10);
    //�����С
    private Integer[] fontSize = {8, 9, 10,11,12,14,16,18,20,22,24,26,28,36,48,72};
    private JList fontSizeList = new JList(fontSize);
    private JTextField fontSizeText = new JTextField(10);
    //ʾ����
    private JLabel exampleLabel = new JLabel("AaBbYyZz");
    //�ű�
    private String[] scenario = {"��ŷ����", "���� GB2312"};
    private String[] example = {"AaBbYyZz", "ϰ�����񣬳ͷ�����"};
    private JComboBox scenarioList = new JComboBox(scenario);
    private NotepadFrame frame;
    
    public FontDialog(NotepadFrame frame){
        super(frame, "����");
        this.frame = frame;
        //���öԻ�����Frame����
        int frameX = (int)frame.getBounds().getX();
        int frameY = (int)frame.getBounds().getY();
        setBounds(frameX+40, frameY+80, 0, 0);
        //����������
        JPanel up = new JPanel();
        up.add(createFontList());
        up.add(createFontStyleList());
        up.add(createFontSizeList());
        add(up, BorderLayout.NORTH);
        //�·����
        JPanel center = new JPanel();
        center.add(createExamplePanel());
        center.add(createScenarioPanel());
        //����
        JPanel downRight = new JPanel(new GridLayout(2, 1, 0, 10));
        JButton ensure = new JButton("ȷ��");
        ensure.addActionListener(ActionListenerFactory.getActionListener(this, "ȷ��"));
        JButton cancel = new JButton("ȡ��");
        cancel.addActionListener(ActionListenerFactory.getActionListener(this, "ȡ��"));
        downRight.add(ensure);	
        downRight.add(cancel);
        center.add(downRight);
        add(center,BorderLayout.SOUTH);
        pack();
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
    }
    
    // ���ö�Ӧ��TextArea������
    public void setTextAreaFont(Font font){
        frame.setTextAreaFont(font);
    }
    
    //����ʾ��ComboBox��ѡ��ֵ����ʾ���ı�
    public String getScenarioListValue(){
        String select = (String)this.scenarioList.getSelectedItem();
        if("��ŷ����".equals(select)){
            return example[0];
        }else{
            return  example[1];
        }
    }
    
    // ����ʾ��JLabel������
    public void setExampleText(String text){
        this.exampleLabel.setText(text);
    }
    
    // ����ʾ��JLabel������
    public void setExampleFont(Font font){
        this.exampleLabel.setFont(font);
    }
    
    //���������СList�Ϸ����ı����ֵ
    public void setFontSizeTextField(int n){
        this.fontSizeText.setText(String.valueOf(n));
    }
    
    //��ȡ�����С�б���ѡ��ֵ
    public int getFontSizeListValue(){
        return (Integer)this.fontSizeList.getSelectedValue();
    }
    
    // ��������List�Ϸ����ı����ֵ
    public void setFontStyleTextField(String text){
        this.fontStyleText.setText(text);
    }
    
    //��ȡ�����б���ѡ��ֵ������ת�������γ���ֵ
    public int getFontStyleListValue(){
        String fontStyleName = (String)this.fontStyleList.getSelectedValue();
        for(int i = 0; i < fontStyle.length; i++){
            if(fontStyle[i].equals(fontStyleName)) return i;
        }
        return 0;
    }
    
    //��������JList�Ϸ����ı����ֵ
    public void setFontTextField(String text){
        this.fontText.setText(text);
    }
    
    //��ȡ�����б���ѡ��ֵ
    public String getFontListValue(){
        return (String)this.fontList.getSelectedValue();
    }
    
    // ʾ�����õĽű�
    private JPanel createScenarioPanel(){
        JLabel label = new JLabel("�ű���");
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(label, BorderLayout.NORTH);
        panel.add(scenarioList);
        scenarioList.addItemListener(ItemListenerFactory.getListener(this, "�ű�"));
        panel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        return panel;
    }
    
    // ʾ����
    private JPanel createExamplePanel(){
        exampleLabel.setFont(frame.getTextAreaFont());
        exampleLabel.setHorizontalAlignment(SwingConstants.CENTER);    
        exampleLabel.setPreferredSize(new Dimension(200,40));
//        exampleLabel.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));
        JPanel panel = new JPanel();
        panel.add(exampleLabel);
        panel.setBorder(BorderFactory.createTitledBorder("ʾ��"));
//        panel.setBorder(BorderFactory.createTitledBorder(
//                BorderFactory.createEmptyBorder(10, 10, 10, 10), "ʾ��"));
        return panel;
    }
    
    //�����С�б��
    private JPanel createFontSizeList(){
        fontSizeList.setVisibleRowCount(7);
        fontSizeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane jsp = new JScrollPane(fontSizeList);
        //��ǰʹ�õ�����
        int fontSize = frame.getTextAreaFont().getSize();
        fontSizeList.setSelectedValue(fontSize, true);
        fontSizeText.setText(String.valueOf(fontSizeList.getSelectedValue()));
        fontSizeList.addListSelectionListener(ListSelectionListenerFactory.getListener(this, "��С"));
        JLabel label = new JLabel("��С��");
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(label, BorderLayout.NORTH);
        panel.add(this.fontSizeText);
        panel.add(jsp, BorderLayout.SOUTH);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return panel;
    }
    
    //�����б��
    private JPanel createFontStyleList(){
        fontStyleList.setVisibleRowCount(7);
        fontStyleList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane jsp = new JScrollPane(fontStyleList);
        //��ǰʹ�õ�����
        int fontStyleConst = frame.getTextAreaFont().getStyle();
        fontStyleList.setSelectedValue(fontStyle[fontStyleConst], true);
        fontStyleText.setText((String)fontStyleList.getSelectedValue());
        fontStyleList.addListSelectionListener(ListSelectionListenerFactory.getListener(this, "����"));
        JLabel label = new JLabel("���Σ�");
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(label, BorderLayout.NORTH);
        panel.add(this.fontStyleText);
        panel.add(jsp, BorderLayout.SOUTH);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return panel;
    }
    
    // �����б��
    private JPanel createFontList(){
//        �����Զ����ı���Ⱦ����ʹÿ���б���ʾ�����������
//        ����ô˷������������Ի���ʱ�Ῠ���룬����ȡ��
//        fontList.setCellRenderer(new MyCellRenderer()); 
        fontList.setVisibleRowCount(7);
        JScrollPane jsp = new JScrollPane(fontList); //����д��scrollRectToVisible֮ǰ����ʹ������Ч
        fontList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //��ǰʹ�õ�����
        String fontName = frame.getTextAreaFont().getFamily(); //�ı���ʹ�õĵ�ǰ����
        fontList.setSelectedValue(fontName, true); //ѡ������
        fontText.setText((String)fontList.getSelectedValue());
        int index = fontList.getSelectedIndex(); //����ѡ�е�����
        Rectangle rect = fontList.getCellBounds(index, index);
        fontList.scrollRectToVisible(rect); //ѡ������ʾ�ڵ�һ��
        fontList.addListSelectionListener(ListSelectionListenerFactory.getListener(this, "����"));
        //���������
        //�б���Ϸ��ı�ǩ�������
        JLabel label = new JLabel("���壺");
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(label, BorderLayout.NORTH);
        panel.add(fontText);
        panel.add(jsp, BorderLayout.SOUTH);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return panel;
    }
}
