package org.appinventor;
import com.google.appinventor.components.runtime.HandlesEventDispatching;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.Form;
import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.Label;
import com.google.appinventor.components.runtime.ListPicker;
import com.google.appinventor.components.runtime.TableArrangement;
import com.google.appinventor.components.runtime.Button;
import com.google.appinventor.components.runtime.BluetoothClient;
import com.google.appinventor.components.runtime.TextToSpeech;
import com.google.appinventor.components.runtime.util.YailList;
class Screen1 extends Form implements HandlesEventDispatching {
  private Label Label1;
  private ListPicker ListPicker1;
  private TableArrangement TableArrangement1;
  private Button Forward;
  private Button Stop;
  private Button Backward;
  private Button Right;
  private Button Left;
  private BluetoothClient BluetoothClient1;
  private TextToSpeech TextToSpeech1;
  protected void $define() {
    this.AlignHorizontal(3);
    this.AlignVertical(2);
    this.AppName("automatic_car_with_fire_detection");
    this.Icon("firedectector.png");
    this.Title("Screen1");
    Label1 = new Label(this);
    Label1.FontBold(true);
    Label1.FontSize(20);
    Label1.Text("Available Device");
    Label1.TextColor(0xFFFF00FF);
    ListPicker1 = new ListPicker(this);
    ListPicker1.Text("Show Device");
    TableArrangement1 = new TableArrangement(this);
    TableArrangement1.Columns(3);
    TableArrangement1.Rows(3);
    Forward = new Button(TableArrangement1);
    Forward.BackgroundColor(0xFF00FFFF);
    Forward.Column(1);
    Forward.Height(-1020);
    Forward.Width(-1030);
    Forward.Row(0);
    Forward.Shape(2);
    Forward.Text("F");
    Stop = new Button(TableArrangement1);
    Stop.BackgroundColor(0xFF00FF00);
    Stop.Column(1);
    Stop.Height(-1020);
    Stop.Width(-1030);
    Stop.Row(1);
    Stop.Text("S");
    Backward = new Button(TableArrangement1);
    Backward.BackgroundColor(0xFF00FFFF);
    Backward.Column(1);
    Backward.Height(-1020);
    Backward.Width(-1030);
    Backward.Row(2);
    Backward.Text("B");
    Right = new Button(TableArrangement1);
    Right.BackgroundColor(0xFF00FFFF);
    Right.Column(2);
    Right.Height(-1020);
    Right.Width(-1030);
    Right.Row(1);
    Right.Text("R");
    Left = new Button(TableArrangement1);
    Left.BackgroundColor(0xFF00FFFF);
    Left.Column(0);
    Left.Height(-1020);
    Left.Width(-1030);
    Left.Row(1);
    Left.Text("L");
    BluetoothClient1 = new BluetoothClient(this);
    TextToSpeech1 = new TextToSpeech(this);
    EventDispatcher.registerEventForDelegation(this, "InitializeEvent", "Initialize" );
    EventDispatcher.registerEventForDelegation(this, "AfterPickingEvent", "AfterPicking" );
    EventDispatcher.registerEventForDelegation(this, "ClickEvent", "Click" );
  }
  public boolean dispatchEvent(Component component, String componentName, String eventName, Object[] params){
    if( component.equals(this) && eventName.equals("Initialize") ){
      thisInitialize();
      return true;
    }
    if( component.equals(ListPicker1) && eventName.equals("AfterPicking") ){
      ListPicker1AfterPicking();
      return true;
    }
    if( component.equals(Forward) && eventName.equals("Click") ){
      ForwardClick();
      return true;
    }
    if( component.equals(Backward) && eventName.equals("Click") ){
      BackwardClick();
      return true;
    }
    if( component.equals(Right) && eventName.equals("Click") ){
      RightClick();
      return true;
    }
    if( component.equals(Left) && eventName.equals("Click") ){
      LeftClick();
      return true;
    }
    return false;
  }
  public void thisInitialize(){
    ListPicker1.Elements(YailList.makeList(BluetoothClient1.AddressesAndNames()));
  }
  public void ListPicker1AfterPicking(){
    BluetoothClient1.Connect(ListPicker1.Selection());
  }
  public void ForwardClick(){
    BluetoothClient1.SendText("F");
    TextToSpeech1.Speak("Forward");
  }
  public void BackwardClick(){
    BluetoothClient1.SendText("B");
    TextToSpeech1.Speak("Backward");
  }
  public void RightClick(){
    BluetoothClient1.SendText("R");
    TextToSpeech1.Speak("Right turn");
  }
  public void LeftClick(){
    BluetoothClient1.SendText("L");
    TextToSpeech1.Speak("Left turn");
  }
}