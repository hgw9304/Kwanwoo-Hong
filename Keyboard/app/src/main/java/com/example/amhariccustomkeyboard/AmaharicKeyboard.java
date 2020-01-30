package com.example.amhariccustomkeyboard;

import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.media.AudioManager;
import android.text.Editable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import android.widget.Toast;

import com.example.amhariccustomkeyboard.R;


public class AmaharicKeyboard extends InputMethodService implements KeyboardView.OnKeyboardActionListener {

    private KeyboardView keyboardView;
    private Keyboard keyboard;
    int key_family = 0;
    int first_time_selected = 0;
    int i = 0;
    public final static int CodeMult = 30024; //X
    public final static int CodeDivi = 30025; //割り算
    public final static int CodePlus = 30026; //+
    public final static int CodeMinus = 30027; //-
    public final static int CodeB1 = 30028; //◆
    public final static int CodeB2 = 30029; //
    public final static int CodeB3 = 30030; //
    public final static int CodeB4 = 30031; //
    public final static int CodeAlpha2 = 10081;
    public final static int CodeAlpha = 10080;
    public final static int CodeNumber = 10070;
    public final static int CodeNumber2 = 10071;
   //清音
   public final static int CodeKI2 = 9999;
    public final static int CodeKI = 10000;
    public final static int CodeA = 10001;
    public final static int CodeK = 10002;
    public final static int CodeS = 10003;
    public final static int CodeT = 10004;
    public final static int CodeN = 10005;
    public final static int CodeH = 10006;
    public final static int CodeM = 10007;
    public final static int CodeY = 10008;
    public final static int CodeR = 10009;
    public final static int CodeW = 10010;
   //カタカナ
    public final static int CodeKA = 10011;
    public final static int CodeKK = 10012;
    public final static int CodeKS = 10013;
    public final static int CodeKT = 10014;
    public final static int CodeKN = 10015;
    public final static int CodeKH = 10016;
    public final static int CodeKM = 10017;
    public final static int CodeKY = 10018;
    public final static int CodeKR = 10019;
    public final static int CodeKW = 10020;

   //濁音 判濁音
    public final static int CodeDK = 10021;
    public final static int CodeDS = 10022;
    public final static int CodeDT = 10023;
    public final static int CodeDH = 10024;
    public final static int CodeHH = 10025;

   //濁音 判濁音　カタカナ
    public final static int CodeKDK = 10026;
    public final static int CodeKDS = 10027;
    public final static int CodeKDT = 10028;
    public final static int CodeKDH = 10029;
    public final static int CodeKHH = 10030;
   //X
    public final static int CodeA1 = 10031; //ぁ
    public final static int CodeA2 = 10032; //ァ
    public final static int CodeK1 = 10033; //ゕ
    public final static int CodeK2 = 10034; //ヵ

    public final static int CodeY1 = 10037; //ゃゅょ
    public final static int CodeY2 = 10038; //ャュョ

   //Y
   public final static int CodeYK1 = 30000; //きゃ
   public final static int CodeYK2 = 30001; //キャ
   public final static int CodeYG1 = 30002; //ぎゃ
   public final static int CodeYG2 = 30003; //ギャ
   public final static int CodeYS1 = 30004; //しゃ
   public final static int CodeYS2 = 30005; //シャ
   public final static int CodeYZ1 = 30006; //じゃ
   public final static int CodeYZ2 = 30007; //ジャ
   public final static int CodeYT1 = 30008; //ちゃ
   public final static int CodeYT2 = 30009; //チャ
   public final static int CodeYD1 = 30010; //ぢゃ
   public final static int CodeYD2 = 30011; //ヂャ
   public final static int CodeYN1 = 30012; //にゃ
   public final static int CodeYN2 = 30013; //ニャ
   public final static int CodeYH1 = 30014; //ひゃ
   public final static int CodeYH2 = 30015; //ヒャ
   public final static int CodeYB1 = 30016; //びゃ
   public final static int CodeYB2 = 30017; //ビャ
   public final static int CodeYP1 = 30018; //ぴゃ
   public final static int CodeYP2 = 30019; //ピャ
   public final static int CodeYM1 = 30020; //みゃ
   public final static int CodeYM2 = 30021; //ミャ
   public final static int CodeYR1 = 30022; //りゃ
   public final static int CodeYR2 = 30023; //リャ




   //きゃ
    public final static int Codek1 = 20000;
    public final static int Codek2 = 20001;
    public final static int Codek3 = 20002;
    public final static int Codek4 = 20003;
    public final static int Codek5 = 20004;

   //キャ
    public final static int Codek6 = 20040;
    public final static int Codek7 = 20041;
    public final static int Codek8 = 20042;
    public final static int Codek9 = 20043;
    public final static int Codek0 = 20044;

    //ぎゃ
    public final static int Codeg1 = 20100;
    public final static int Codeg2 = 20101;
    public final static int Codeg3 = 20102;
    public final static int Codeg4 = 20103;
    public final static int Codeg5 = 20104;

    //ギャ
    public final static int Codeg6 = 20105;
    public final static int Codeg7 = 20106;
    public final static int Codeg8 = 20107;
    public final static int Codeg9 = 20108;
    public final static int Codeg0 = 20109;

    //しゃ
    public final static int Codes1 = 20005;
    public final static int Codes2 = 20006;
    public final static int Codes3 = 20007;
    public final static int Codes4 = 20008;
    public final static int Codes5 = 20009;

    //シャ
    public final static int Codes6 = 20045;
    public final static int Codes7 = 20046;
    public final static int Codes8 = 20047;
    public final static int Codes9 = 20048;
    public final static int Codes0 = 20049;
    //じゃ
    public final static int Codez1 = 20110;
    public final static int Codez2 = 20111;
    public final static int Codez3 = 20112;
    public final static int Codez4 = 20113;
    public final static int Codez5 = 20114;

    //ジャ
    public final static int Codez6 = 20115;
    public final static int Codez7 = 20116;
    public final static int Codez8 = 20117;
    public final static int Codez9 = 20118;
    public final static int Codez0 = 20119;

   //ちゃ
    public final static int Codet1 = 20010;
    public final static int Codet2 = 20011;
    public final static int Codet3 = 20012;
    public final static int Codet4 = 20013;
    public final static int Codet5 = 20014;

   //チャ
    public final static int Codet6 = 20050;
    public final static int Codet7 = 20051;
    public final static int Codet8 = 20052;
    public final static int Codet9 = 20053;
    public final static int Codet0 = 20054;
   //ぢゃ
    public final static int Coded1 = 20120;
    public final static int Coded2 = 20121;
    public final static int Coded3 = 20122;
    public final static int Coded4 = 20123;
    public final static int Coded5 = 20124;
   //ヂャ
    public final static int Coded6 = 20125;
    public final static int Coded7 = 20126;
    public final static int Coded8 = 20127;
    public final static int Coded9 = 20128;
    public final static int Coded0 = 20129;
   //にゃ
    public final static int Coden1 = 20015;
    public final static int Coden2 = 20016;
    public final static int Coden3 = 20017;
    public final static int Coden4 = 20018;
    public final static int Coden5 = 20019;
   //ニャ
    public final static int Coden6 = 20055;
    public final static int Coden7 = 20056;
    public final static int Coden8 = 20057;
    public final static int Coden9 = 20058;
    public final static int Coden0 = 20059;
   //ひゃ
    public final static int Codeh1 = 20020;
    public final static int Codeh2 = 20021;
    public final static int Codeh3 = 20022;
    public final static int Codeh4 = 20023;
    public final static int Codeh5 = 20024;
   //ヒャ
    public final static int Codeh6 = 20090;
    public final static int Codeh7 = 20091;
    public final static int Codeh8 = 20092;
    public final static int Codeh9 = 20093;
    public final static int Codeh0 = 20094;


   //びゃ
    public final static int Codeb1 = 20060;
    public final static int Codeb2 = 20061;
    public final static int Codeb3 = 20062;
    public final static int Codeb4 = 20063;
    public final static int Codeb5 = 20064;

    //ビャ
    public final static int Codeb6 = 20080;
    public final static int Codeb7 = 20081;
    public final static int Codeb8 = 20082;
    public final static int Codeb9 = 20083;
    public final static int Codeb0 = 20084;

   //ぴゃ
    public final static int Codep1 = 20065;
    public final static int Codep2 = 20066;
    public final static int Codep3 = 20067;
    public final static int Codep4 = 20068;
    public final static int Codep5 = 20069;
    //ピャ
    public final static int Codep6 = 20085;
    public final static int Codep7 = 20086;
    public final static int Codep8 = 20087;
    public final static int Codep9 = 20088;
    public final static int Codep0 = 20089;

   //みゃ
    public final static int Codem1 = 20025;
    public final static int Codem2 = 20026;
    public final static int Codem3 = 20027;
    public final static int Codem4 = 20028;
    public final static int Codem5 = 20029;
   //ミャ
    public final static int Codem6 = 20070;
    public final static int Codem7 = 20071;
    public final static int Codem8 = 20072;
    public final static int Codem9 = 20073;
    public final static int Codem0 = 20074;
   //りゃ
    public final static int Coder1 = 20030;
    public final static int Coder2 = 20031;
    public final static int Coder3 = 20032;
    public final static int Coder4 = 20033;
    public final static int Coder5 = 20034;
   //リャ
    public final static int Coder6 = 20075;
    public final static int Coder7 = 20076;
    public final static int Coder8 = 20077;
    public final static int Coder9 = 20078;
    public final static int Coder0 = 20079;


    public final static int KEYCODE_Left = 21;
    public final static int KEYCODE_Right = 22;

    @Override
    public View onCreateInputView() {
        keyboardView = (KeyboardView) getLayoutInflater().inflate(R.layout.keyboard, null);
        keyboard = new Keyboard(this,R.xml.qwerty);
        keyboardView.setKeyboard(keyboard);
        keyboardView.setOnKeyboardActionListener(this);
        return keyboardView;
    }

    @Override
    public void onPress(int primaryCode) {

    }

    @Override
    public void onRelease(int primaryCode) {

    }


    private void switchKeyboard(InputConnection inputConnection, int i){

        switch(i){
//あ
            case 12354:
            case 12356:
            case 12358:
            case 12360:
            case 12362:
//か
            case 12363:
            case 12365:
            case 12367:
            case 12369:
            case 12371:
//さ
            case 12373:
            case 12375:
            case 12377:
            case 12379:
            case 12381:
//た
            case 12383:
            case 12385:
            case 12388:
            case 12390:
            case 12392:
//な
            case 12394:
            case 12395:
            case 12396:
            case 12397:
            case 12398:
//は
            case 12399:
            case 12402:
            case 12405:
            case 12408:
            case 12411:
//ま
            case 12414:
            case 12415:
            case 12416:
            case 12417:
            case 12418:
//や
            case 12420:
            case 12422:
            case 12424:
//ら
            case 12425:
            case 12426:
            case 12427:
            case 12428:
            case 12429:
//わ
            case 12431:
            case 12434:


//ア
            case 12450:
            case 12452:
            case 12454:
            case 12456:
            case 12458:
//カ
            case 12459:
            case 12461:
            case 12463:
            case 12465:
            case 12467:
//サ
            case 12469:
            case 12471:
            case 12473:
            case 12475:
            case 12477:
//タ
            case 12479:
            case 12481:
            case 12484:
            case 12486:
            case 12488:
//ナ
            case 12490:
            case 12491:
            case 12492:
            case 12493:
            case 12494:
//ハ
            case 12495:
            case 12498:
            case 12501:
            case 12504:
            case 12507:
//マ
            case 12510:
            case 12511:
            case 12512:
            case 12513:
            case 12514:
//ヤ
            case 12516:
            case 12518:
            case 12520:
//ラ
            case 12521:
            case 12522:
            case 12523:
            case 12524:
            case 12525:
//ワ
            case 12527:
            case 12530:
//が
            case 12364:
            case 12366:
            case 12368:
            case 12370:
            case 12372:
//ざ
            case 12374:
            case 12376:
            case 12378:
            case 12380:
            case 12382:
//だ
            case 12384:
            case 12386:
            case 12389:
            case 12391:
            case 12393:
//ば
            case 12400:
            case 12403:
            case 12406:
            case 12409:
            case 12412:
//ぱ
            case 12401:
            case 12404:
            case 12407:
            case 12410:
            case 12413:
//ガ
            case 12460:
            case 12462:
            case 12464:
            case 12466:
            case 12468:
//ザ
            case 12470:
            case 12472:
            case 12474:
            case 12476:
            case 12478:
//ダ
            case 12480:
            case 12482:
            case 12485:
            case 12487:
            case 12489:
//バ
            case 12496:
            case 12499:
            case 12502:
            case 12505:
            case 12508:
//パ
            case 12497:
            case 12500:
            case 12503:
            case 12506:
            case 12509:
//小あ
            case 12353:
            case 12355:
            case 12357:
            case 12359:
            case 12361:
//ゕゖ
            case 12437:
            case 12438:
//っ
            case 12387:
//ゃゅょ
            case 12419:
            case 12421:
            case 12423:
//ゎ
            case 12430:

//小ア
            case 12449:
            case 12451:
            case 12453:
            case 12455:
            case 12457:
//ヵヶ
            case 12533:
            case 12534:
//ッ
            case 12483:
//ャュョ
            case 12515:
            case 12517:
            case 12519:
//ヮ
            case 12526:
            case 12435:
            case 12531:

//kya
            case 20000:
            case 20001:
            case 20002:
            case 20003:
            case 20004:

            case 20040:
            case 20041:
            case 20042:
            case 20043:
            case 20044:

//gya
            case 20100:
            case 20101:
            case 20102:
            case 20103:
            case 20104:

            case 20105:
            case 20106:
            case 20107:
            case 20108:
            case 20109:

//sya
            case 20005:
            case 20006:
            case 20007:
            case 20008:
            case 20009:

            case 20045:
            case 20046:
            case 20047:
            case 20048:
            case 20049:
//zya
            case 20110:
            case 20111:
            case 20112:
            case 20113:
            case 20114:

            case 20115:
            case 20116:
            case 20117:
            case 20118:
            case 20119:
//tya
            case 20010:
            case 20011:
            case 20012:
            case 20013:
            case 20014:

            case 20050:
            case 20051:
            case 20052:
            case 20053:
            case 20054:
//dya
            case 20120:
            case 20121:
            case 20122:
            case 20123:
            case 20124:

            case 20125:
            case 20126:
            case 20127:
            case 20128:
            case 20129:
//nya
            case 20015:
            case 20016:
            case 20017:
            case 20018:
            case 20019:

            case 20055:
            case 20056:
            case 20057:
            case 20058:
            case 20059:
//hya
            case 20020:
            case 20021:
            case 20022:
            case 20023:
            case 20024:

            case 20090:
            case 20091:
            case 20092:
            case 20093:
            case 20094:
//bya
            case 20060:
            case 20061:
            case 20062:
            case 20063:
            case 20064:

            case 20080:
            case 20081:
            case 20082:
            case 20083:
            case 20084:
//pya
            case 20065:
            case 20066:
            case 20067:
            case 20068:
            case 20069:

            case 20085:
            case 20086:
            case 20087:
            case 20088:
            case 20089:

//mya
            case 20025:
            case 20026:
            case 20027:
            case 20028:
            case 20029:

            case 20070:
            case 20071:
            case 20072:
            case 20073:
            case 20074:

//rya
            case 20030:
            case 20031:
            case 20032:
            case 20033:
            case 20034:

            case 20075:
            case 20076:
            case 20077:
            case 20078:
            case 20079:


                Log.d("test","i: "+i);
                keyboard = new Keyboard(this,R.xml.qwerty);
                keyboardView.setKeyboard(keyboard);
                keyboardView.setOnKeyboardActionListener(this);
                break;


        }
    }


    @Override
    public void onKey(int primaryCode, int[] keyCodes) {
        InputConnection inputConnection = getCurrentInputConnection();
        switchKeyboard(inputConnection, primaryCode);



        switch (primaryCode){
            case Keyboard.KEYCODE_DELETE:
                inputConnection.deleteSurroundingText(1,0);
                break;
            case Keyboard.KEYCODE_DONE:
                inputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
                break;


            case CodeAlpha:


                Log.d("test","i: "+i);
                keyboard = new Keyboard(this,R.xml.alphabet);
                keyboardView.setKeyboard(keyboard);
                keyboardView.setOnKeyboardActionListener(this);
                break;
            case CodeAlpha2:


                Log.d("test","i: "+i);
                keyboard = new Keyboard(this,R.xml.alphabet2);
                keyboardView.setKeyboard(keyboard);
                keyboardView.setOnKeyboardActionListener(this);
                break;
            case CodeNumber:


                Log.d("test","i: "+i);
                keyboard = new Keyboard(this,R.xml.number1);
                keyboardView.setKeyboard(keyboard);
                keyboardView.setOnKeyboardActionListener(this);
                break;
            case CodeNumber2:


                Log.d("test","i: "+i);
                keyboard = new Keyboard(this,R.xml.number2);
                keyboardView.setKeyboard(keyboard);
                keyboardView.setOnKeyboardActionListener(this);
                break;


                case CodeKI:


                Log.d("test","i: "+i);
                keyboard = new Keyboard(this,R.xml.qwerty);
                keyboardView.setKeyboard(keyboard);
                keyboardView.setOnKeyboardActionListener(this);
                break;

            case CodeKI2:


                Log.d("test","i: "+i);
                keyboard = new Keyboard(this,R.xml.qwerty2);
                keyboardView.setKeyboard(keyboard);
                keyboardView.setOnKeyboardActionListener(this);
                break;

            case CodeA:

                Log.d("test","i: "+i);
                keyboard = new Keyboard(this,R.xml.aa);
                keyboardView.setKeyboard(keyboard);
                keyboardView.setOnKeyboardActionListener(this);
                break;




//ひらがな
        case CodeK:
        Log.d("test","i: "+i);
        keyboard = new Keyboard(this,R.xml.ka);
        keyboardView.setKeyboard(keyboard);
        keyboardView.setOnKeyboardActionListener(this);
        break;
        case CodeS:
        Log.d("test","i: "+i);
        keyboard = new Keyboard(this,R.xml.sa);
        keyboardView.setKeyboard(keyboard);
        keyboardView.setOnKeyboardActionListener(this);
        break;
        case CodeT:
        Log.d("test","i: "+i);
        keyboard = new Keyboard(this,R.xml.ta);
        keyboardView.setKeyboard(keyboard);
        keyboardView.setOnKeyboardActionListener(this);
        break;
        case CodeN:
        Log.d("test","i: "+i);
        keyboard = new Keyboard(this,R.xml.na);
        keyboardView.setKeyboard(keyboard);
        keyboardView.setOnKeyboardActionListener(this);
        break;
        case CodeH:
        Log.d("test","i: "+i);
        keyboard = new Keyboard(this,R.xml.ha);
        keyboardView.setKeyboard(keyboard);
        keyboardView.setOnKeyboardActionListener(this);
        break;
        case CodeM:
        Log.d("test","i: "+i);
        keyboard = new Keyboard(this,R.xml.ma);
        keyboardView.setKeyboard(keyboard);
        keyboardView.setOnKeyboardActionListener(this);
        break;
        case CodeY:
        Log.d("test","i: "+i);
        keyboard = new Keyboard(this,R.xml.ya);
        keyboardView.setKeyboard(keyboard);
        keyboardView.setOnKeyboardActionListener(this);
        break;
        case CodeR:
        Log.d("test","i: "+i);
        keyboard = new Keyboard(this,R.xml.ra);
        keyboardView.setKeyboard(keyboard);
        keyboardView.setOnKeyboardActionListener(this);
        break;
        case CodeW:
        Log.d("test","i: "+i);
        keyboard = new Keyboard(this,R.xml.wa);
        keyboardView.setKeyboard(keyboard);
        keyboardView.setOnKeyboardActionListener(this);
        break;
//カタカナ
            case CodeKA:
                Log.d("test","i: "+i);
                keyboard = new Keyboard(this,R.xml.kaa);
                keyboardView.setKeyboard(keyboard);
                keyboardView.setOnKeyboardActionListener(this);
                break;
            case CodeKK:
                Log.d("test","i: "+i);
                keyboard = new Keyboard(this,R.xml.kka);
                keyboardView.setKeyboard(keyboard);
                keyboardView.setOnKeyboardActionListener(this);
                break;
            case CodeKS:
                Log.d("test","i: "+i);
                keyboard = new Keyboard(this,R.xml.ksa);
                keyboardView.setKeyboard(keyboard);
                keyboardView.setOnKeyboardActionListener(this);
                break;
            case CodeKT:
                Log.d("test","i: "+i);
                keyboard = new Keyboard(this,R.xml.kta);
                keyboardView.setKeyboard(keyboard);
                keyboardView.setOnKeyboardActionListener(this);
                break;
            case CodeKN:
                Log.d("test","i: "+i);
                keyboard = new Keyboard(this,R.xml.kna);
                keyboardView.setKeyboard(keyboard);
                keyboardView.setOnKeyboardActionListener(this);
                break;
            case CodeKH:
                Log.d("test","i: "+i);
                keyboard = new Keyboard(this,R.xml.kha);
                keyboardView.setKeyboard(keyboard);
                keyboardView.setOnKeyboardActionListener(this);
                break;
            case CodeKM:
                Log.d("test","i: "+i);
                keyboard = new Keyboard(this,R.xml.kma);
                keyboardView.setKeyboard(keyboard);
                keyboardView.setOnKeyboardActionListener(this);
                break;
            case CodeKY:
                Log.d("test","i: "+i);
                keyboard = new Keyboard(this,R.xml.kya);
                keyboardView.setKeyboard(keyboard);
                keyboardView.setOnKeyboardActionListener(this);
                break;
            case CodeKR:
                Log.d("test","i: "+i);
                keyboard = new Keyboard(this,R.xml.kra);
                keyboardView.setKeyboard(keyboard);
                keyboardView.setOnKeyboardActionListener(this);
                break;
            case CodeKW:
                Log.d("test","i: "+i);
                keyboard = new Keyboard(this,R.xml.kwa);
                keyboardView.setKeyboard(keyboard);
                keyboardView.setOnKeyboardActionListener(this);
                break;


//濁音・半濁音
            case CodeDK:
                Log.d("test","i: "+i);
                keyboard = new Keyboard(this,R.xml.dk);
                keyboardView.setKeyboard(keyboard);
                keyboardView.setOnKeyboardActionListener(this);
                break;
            case CodeDS:
                Log.d("test","i: "+i);
                keyboard = new Keyboard(this,R.xml.ds);
                keyboardView.setKeyboard(keyboard);
                keyboardView.setOnKeyboardActionListener(this);
                break;
            case CodeDT:
                Log.d("test","i: "+i);
                keyboard = new Keyboard(this,R.xml.dt);
                keyboardView.setKeyboard(keyboard);
                keyboardView.setOnKeyboardActionListener(this);
                break;
            case CodeDH:
                Log.d("test","i: "+i);
                keyboard = new Keyboard(this,R.xml.dh);
                keyboardView.setKeyboard(keyboard);
                keyboardView.setOnKeyboardActionListener(this);
                break;
            case CodeHH:
                Log.d("test","i: "+i);
                keyboard = new Keyboard(this,R.xml.dh3);
                keyboardView.setKeyboard(keyboard);
                keyboardView.setOnKeyboardActionListener(this);
                break;
//カタカナ　濁音・半濁音
            case CodeKDK:
                Log.d("test","i: "+i);
                keyboard = new Keyboard(this,R.xml.dk2);
                keyboardView.setKeyboard(keyboard);
                keyboardView.setOnKeyboardActionListener(this);
                break;
            case CodeKDS:
                Log.d("test","i: "+i);
                keyboard = new Keyboard(this,R.xml.ds2);
                keyboardView.setKeyboard(keyboard);
                keyboardView.setOnKeyboardActionListener(this);
                break;
            case CodeKDT:
                Log.d("test","i: "+i);
                keyboard = new Keyboard(this,R.xml.dt);
                keyboardView.setKeyboard(keyboard);
                keyboardView.setOnKeyboardActionListener(this);
                break;


            case CodeKDH:
                Log.d("test","i: "+i);
                keyboard = new Keyboard(this,R.xml.dh2);
                keyboardView.setKeyboard(keyboard);
                keyboardView.setOnKeyboardActionListener(this);
                break;
            case CodeKHH:
                Log.d("test","i: "+i);
                keyboard = new Keyboard(this,R.xml.dh4);
                keyboardView.setKeyboard(keyboard);
                keyboardView.setOnKeyboardActionListener(this);
                break;
//小文字
            //ぁ
            case CodeA1:
                Log.d("test","i: "+i);
                keyboard = new Keyboard(this,R.xml.a1);
                keyboardView.setKeyboard(keyboard);
                keyboardView.setOnKeyboardActionListener(this);
                break;
            //ァ
            case CodeA2:
                Log.d("test","i: "+i);
                keyboard = new Keyboard(this,R.xml.a2);
                keyboardView.setKeyboard(keyboard);
                keyboardView.setOnKeyboardActionListener(this);
                break;
            //ゕ
            case CodeK1:
                Log.d("test","i: "+i);
                keyboard = new Keyboard(this,R.xml.k1);
                keyboardView.setKeyboard(keyboard);
                keyboardView.setOnKeyboardActionListener(this);
                break;
           //ヵ
            case CodeK2:
                Log.d("test","i: "+i);
                keyboard = new Keyboard(this,R.xml.k2);
                keyboardView.setKeyboard(keyboard);
                keyboardView.setOnKeyboardActionListener(this);
                break;

            //っ
            //ッ
            //ゃゅ
            case CodeY1:
                Log.d("test","i: "+i);
                keyboard = new Keyboard(this,R.xml.y1);
                keyboardView.setKeyboard(keyboard);
                keyboardView.setOnKeyboardActionListener(this);
                break;
            //ャュ
            case CodeY2:
                Log.d("test","i: "+i);
                keyboard = new Keyboard(this,R.xml.y2);
                keyboardView.setKeyboard(keyboard);
                keyboardView.setOnKeyboardActionListener(this);
                break;
            //ゎ


            case KEYCODE_Left:
                InputConnection inputConnection1 = getCurrentInputConnection();
                inputConnection = getCurrentInputConnection();

                String str = inputConnection.getTextBeforeCursor(1000,0).toString();
                inputConnection.setSelection(str.length()-1,str.length()-1);
                break;

            case KEYCODE_Right:

                inputConnection = getCurrentInputConnection();

                String strs = inputConnection.getTextBeforeCursor(1000,0).toString();
                inputConnection.setSelection(strs.length()+1,strs.length()+1);
                break;

            case CodeYK1:
                Log.d("test","i: "+i);
                keyboard = new Keyboard(this,R.xml.yka1);
                keyboardView.setKeyboard(keyboard);
                keyboardView.setOnKeyboardActionListener(this);
                break;
            case CodeYK2:
                Log.d("test","i: "+i);
                keyboard = new Keyboard(this,R.xml.yka2);
                keyboardView.setKeyboard(keyboard);
                keyboardView.setOnKeyboardActionListener(this);
                break;

            case CodeYG1:
                Log.d("test","i: "+i);
                keyboard = new Keyboard(this,R.xml.yga1);
                keyboardView.setKeyboard(keyboard);
                keyboardView.setOnKeyboardActionListener(this);
                break;
            case CodeYG2:
                Log.d("test","i: "+i);
                keyboard = new Keyboard(this,R.xml.yga2);
                keyboardView.setKeyboard(keyboard);
                keyboardView.setOnKeyboardActionListener(this);
                break;

            case CodeYS1:
                Log.d("test","i: "+i);
                keyboard = new Keyboard(this,R.xml.ysa1);
                keyboardView.setKeyboard(keyboard);
                keyboardView.setOnKeyboardActionListener(this);
                break;
            case CodeYS2:
                Log.d("test","i: "+i);
                keyboard = new Keyboard(this,R.xml.ysa2);
                keyboardView.setKeyboard(keyboard);
                keyboardView.setOnKeyboardActionListener(this);
                break;

            case CodeYZ1:
                Log.d("test","i: "+i);
                keyboard = new Keyboard(this,R.xml.yza1);
                keyboardView.setKeyboard(keyboard);
                keyboardView.setOnKeyboardActionListener(this);
                break;
            case CodeYZ2:
                Log.d("test","i: "+i);
                keyboard = new Keyboard(this,R.xml.yza2);
                keyboardView.setKeyboard(keyboard);
                keyboardView.setOnKeyboardActionListener(this);
                break;

            case CodeYT1:
                Log.d("test","i: "+i);
                keyboard = new Keyboard(this,R.xml.yta1);
                keyboardView.setKeyboard(keyboard);
                keyboardView.setOnKeyboardActionListener(this);
                break;
            case CodeYT2:
                Log.d("test","i: "+i);
                keyboard = new Keyboard(this,R.xml.yta2);
                keyboardView.setKeyboard(keyboard);
                keyboardView.setOnKeyboardActionListener(this);
                break;

            case CodeYD1:
                Log.d("test","i: "+i);
                keyboard = new Keyboard(this,R.xml.yda1);
                keyboardView.setKeyboard(keyboard);
                keyboardView.setOnKeyboardActionListener(this);
                break;
            case CodeYD2:
                Log.d("test","i: "+i);
                keyboard = new Keyboard(this,R.xml.yda2);
                keyboardView.setKeyboard(keyboard);
                keyboardView.setOnKeyboardActionListener(this);
                break;

            case CodeYN1:
                Log.d("test","i: "+i);
                keyboard = new Keyboard(this,R.xml.yna1);
                keyboardView.setKeyboard(keyboard);
                keyboardView.setOnKeyboardActionListener(this);
                break;
            case CodeYN2:
                Log.d("test","i: "+i);
                keyboard = new Keyboard(this,R.xml.yna2);
                keyboardView.setKeyboard(keyboard);
                keyboardView.setOnKeyboardActionListener(this);
                break;

            case CodeYH1:
                Log.d("test","i: "+i);
                keyboard = new Keyboard(this,R.xml.yha1);
                keyboardView.setKeyboard(keyboard);
                keyboardView.setOnKeyboardActionListener(this);
                break;
            case CodeYH2:
                Log.d("test","i: "+i);
                keyboard = new Keyboard(this,R.xml.yha2);
                keyboardView.setKeyboard(keyboard);
                keyboardView.setOnKeyboardActionListener(this);
                break;

            case CodeYB1:
                Log.d("test","i: "+i);
                keyboard = new Keyboard(this,R.xml.yba1);
                keyboardView.setKeyboard(keyboard);
                keyboardView.setOnKeyboardActionListener(this);
                break;
            case CodeYB2:
                Log.d("test","i: "+i);
                keyboard = new Keyboard(this,R.xml.yba2);
                keyboardView.setKeyboard(keyboard);
                keyboardView.setOnKeyboardActionListener(this);
                break;

            case CodeYP1:
                Log.d("test","i: "+i);
                keyboard = new Keyboard(this,R.xml.ypa1);
                keyboardView.setKeyboard(keyboard);
                keyboardView.setOnKeyboardActionListener(this);
                break;
            case CodeYP2:
                Log.d("test","i: "+i);
                keyboard = new Keyboard(this,R.xml.ypa2);
                keyboardView.setKeyboard(keyboard);
                keyboardView.setOnKeyboardActionListener(this);
                break;

            case CodeYM1:
                Log.d("test","i: "+i);
                keyboard = new Keyboard(this,R.xml.yma1);
                keyboardView.setKeyboard(keyboard);
                keyboardView.setOnKeyboardActionListener(this);
                break;
            case CodeYM2:
                Log.d("test","i: "+i);
                keyboard = new Keyboard(this,R.xml.yma2);
                keyboardView.setKeyboard(keyboard);
                keyboardView.setOnKeyboardActionListener(this);
                break;

            case CodeYR1:
                Log.d("test","i: "+i);
                keyboard = new Keyboard(this,R.xml.yra1);
                keyboardView.setKeyboard(keyboard);
                keyboardView.setOnKeyboardActionListener(this);
                break;
            case CodeYR2:
                Log.d("test","i: "+i);
                keyboard = new Keyboard(this,R.xml.yra2);
                keyboardView.setKeyboard(keyboard);
                keyboardView.setOnKeyboardActionListener(this);
                break;


            case Codek1:
                inputConnection.commitText("きゃ", 1);
                break;
            case Codek2:
                inputConnection.commitText("きぃ", 1);
                break;
            case Codek3:
                inputConnection.commitText("きゅ", 1);
                break;
            case Codek4:
                inputConnection.commitText("きぇ", 1);
                break;
            case Codek5:
                inputConnection.commitText("きょ", 1);
                break;
            case Codek6:
                inputConnection.commitText("キャ", 1);
                break;
            case Codek7:
                inputConnection.commitText("キィ", 1);
                break;
            case Codek8:
                inputConnection.commitText("キュ", 1);
                break;
            case Codek9:
                inputConnection.commitText("キェ", 1);
                break;
            case Codek0:
                inputConnection.commitText("キョ", 1);
                break;

            case Codeg1:
                inputConnection.commitText("ぎゃ", 1);
                break;
            case Codeg2:
                inputConnection.commitText("ぎぃ", 1);
                break;
            case Codeg3:
                inputConnection.commitText("ぎゅ", 1);
                break;
            case Codeg4:
                inputConnection.commitText("ぎぇ", 1);
                break;
            case Codeg5:
                inputConnection.commitText("ぎょ", 1);
                break;
            case Codeg6:
                inputConnection.commitText("ギャ", 1);
                break;
            case Codeg7:
                inputConnection.commitText("ギィ", 1);
                break;
            case Codeg8:
                inputConnection.commitText("ギュ", 1);
                break;
            case Codeg9:
                inputConnection.commitText("ギェ", 1);
                break;
            case Codeg0:
                inputConnection.commitText("ギョ", 1);
                break;

            case Codes1:
                inputConnection.commitText("しゃ", 1);
                break;
            case Codes2:
                inputConnection.commitText("しぃ", 1);
                break;
            case Codes3:
                inputConnection.commitText("しゅ", 1);
                break;
            case Codes4:
                inputConnection.commitText("しぇ", 1);
                break;
            case Codes5:
                inputConnection.commitText("しょ", 1);
                break;

            case Codes6:
                inputConnection.commitText("シャ", 1);
                break;
            case Codes7:
                inputConnection.commitText("シィ", 1);
                break;
            case Codes8:
                inputConnection.commitText("シュ", 1);
                break;
            case Codes9:
                inputConnection.commitText("シェ", 1);
                break;
            case Codes0:
                inputConnection.commitText("ショ", 1);
                break;


            case Codez1:
                inputConnection.commitText("じゃ", 1);
                break;
            case Codez2:
                inputConnection.commitText("じぃ", 1);
                break;
            case Codez3:
                inputConnection.commitText("じゅ", 1);
                break;
            case Codez4:
                inputConnection.commitText("じぇ", 1);
                break;
            case Codez5:
                inputConnection.commitText("じょ", 1);
                break;

            case Codez6:
                inputConnection.commitText("ジャ", 1);
                break;
            case Codez7:
                inputConnection.commitText("ジィ", 1);
                break;
            case Codez8:
                inputConnection.commitText("ジュ", 1);
                break;
            case Codez9:
                inputConnection.commitText("ジェ", 1);
                break;
            case Codez0:
                inputConnection.commitText("ジョ", 1);
                break;

            case Codet1:
                inputConnection.commitText("ちゃ", 1);
                break;
            case Codet2:
                inputConnection.commitText("ちぃ", 1);
                break;
            case Codet3:
                inputConnection.commitText("ちゅ", 1);
                break;
            case Codet4:
                inputConnection.commitText("ちぇ", 1);
                break;
            case Codet5:
                inputConnection.commitText("ちょ", 1);
                break;

            case Codet6:
                inputConnection.commitText("チャ", 1);
                break;
            case Codet7:
                inputConnection.commitText("チィ", 1);
                break;
            case Codet8:
                inputConnection.commitText("チュ", 1);
                break;
            case Codet9:
                inputConnection.commitText("チェ", 1);
                break;
            case Codet0:
                inputConnection.commitText("チョ", 1);
                break;

            case Coded1:
                inputConnection.commitText("ぢゃ", 1);
                break;
            case Coded2:
                inputConnection.commitText("ぢぃ", 1);
                break;
            case Coded3:
                inputConnection.commitText("ぢゅ", 1);
                break;
            case Coded4:
                inputConnection.commitText("ぢぇ", 1);
                break;
            case Coded5:
                inputConnection.commitText("ぢょ", 1);
                break;

            case Coded6:
                inputConnection.commitText("ヂャ", 1);
                break;
            case Coded7:
                inputConnection.commitText("ヂィ", 1);
                break;
            case Coded8:
                inputConnection.commitText("ヂュ", 1);
                break;
            case Coded9:
                inputConnection.commitText("ヂェ", 1);
                break;
            case Coded0:
                inputConnection.commitText("ヂョ", 1);
                break;

            case Coden1:
                inputConnection.commitText("にゃ", 1);
                break;
            case Coden2:
                inputConnection.commitText("にぃ", 1);
                break;
            case Coden3:
                inputConnection.commitText("にゅ", 1);
                break;
            case Coden4:
                inputConnection.commitText("にぇ", 1);
                break;
            case Coden5:
                inputConnection.commitText("にょ", 1);
                break;

            case Coden6:
                inputConnection.commitText("ニャ", 1);
                break;
            case Coden7:
                inputConnection.commitText("ニィ", 1);
                break;
            case Coden8:
                inputConnection.commitText("ニュ", 1);
                break;
            case Coden9:
                inputConnection.commitText("ニェ", 1);
                break;
            case Coden0:
                inputConnection.commitText("ニョ", 1);
                break;

            case Codeh1:
                inputConnection.commitText("ひゃ", 1);
                break;
            case Codeh2:
                inputConnection.commitText("ひぃ", 1);
                break;
            case Codeh3:
                inputConnection.commitText("ひゅ", 1);
                break;
            case Codeh4:
                inputConnection.commitText("ひぇ", 1);
                break;
            case Codeh5:
                inputConnection.commitText("ひょ", 1);
                break;

            case Codeh6:
                inputConnection.commitText("ヒャ", 1);
                break;
            case Codeh7:
                inputConnection.commitText("ヒィ", 1);
                break;
            case Codeh8:
                inputConnection.commitText("ヒュ", 1);
                break;
            case Codeh9:
                inputConnection.commitText("ヒェ", 1);
                break;
            case Codeh0:
                inputConnection.commitText("ヒョ", 1);
                break;

            case Codeb1:
                inputConnection.commitText("びゃ", 1);
                break;
            case Codeb2:
                inputConnection.commitText("びぃ", 1);
                break;
            case Codeb3:
                inputConnection.commitText("びゅ", 1);
                break;
            case Codeb4:
                inputConnection.commitText("びぇ", 1);
                break;
            case Codeb5:
                inputConnection.commitText("びょ", 1);
                break;

            case Codeb6:
                inputConnection.commitText("ビャ", 1);
                break;
            case Codeb7:
                inputConnection.commitText("ビィ", 1);
                break;
            case Codeb8:
                inputConnection.commitText("ビュ", 1);
                break;
            case Codeb9:
                inputConnection.commitText("ビェ", 1);
                break;
            case Codeb0:
                inputConnection.commitText("ビョ", 1);
                break;

            case Codep1:
                inputConnection.commitText("ぴゃ", 1);
                break;
            case Codep2:
                inputConnection.commitText("ぴぃ", 1);
                break;
            case Codep3:
                inputConnection.commitText("ぴゅ", 1);
                break;
            case Codep4:
                inputConnection.commitText("ぴぇ", 1);
                break;
            case Codep5:
                inputConnection.commitText("ぴょ", 1);
                break;

            case Codep6:
                inputConnection.commitText("ピャ", 1);
                break;
            case Codep7:
                inputConnection.commitText("ピィ", 1);
                break;
            case Codep8:
                inputConnection.commitText("ピュ", 1);
                break;
            case Codep9:
                inputConnection.commitText("ピェ", 1);
                break;
            case Codep0:
                inputConnection.commitText("ピョ", 1);
                break;

            case Codem1:
                inputConnection.commitText("みゃ", 1);
                break;
            case Codem2:
                inputConnection.commitText("みぃ", 1);
                break;
            case Codem3:
                inputConnection.commitText("みゅ", 1);
                break;
            case Codem4:
                inputConnection.commitText("みぇ", 1);
                break;
            case Codem5:
                inputConnection.commitText("みょ", 1);
                break;

            case Codem6:
                inputConnection.commitText("ミャ", 1);
                break;
            case Codem7:
                inputConnection.commitText("ミィ", 1);
                break;
            case Codem8:
                inputConnection.commitText("ミュ", 1);
                break;
            case Codem9:
                inputConnection.commitText("ミェ", 1);
                break;
            case Codem0:
                inputConnection.commitText("ミョ", 1);
                break;

            case Coder1:
                inputConnection.commitText("りゃ", 1);
                break;
            case Coder2:
                inputConnection.commitText("りぃ", 1);
                break;
            case Coder3:
                inputConnection.commitText("りゅ", 1);
                break;
            case Coder4:
                inputConnection.commitText("りぇ", 1);
                break;
            case Coder5:
                inputConnection.commitText("りょ", 1);
                break;

            case Coder6:
                inputConnection.commitText("リャ", 1);
                break;
            case Coder7:
                inputConnection.commitText("リィ", 1);
                break;
            case Coder8:
                inputConnection.commitText("リュ", 1);
                break;
            case Coder9:
                inputConnection.commitText("リェ", 1);
                break;
            case Coder0:
                inputConnection.commitText("リョ", 1);
                break;
            case CodeMult:
                inputConnection.commitText("×", 1);
                break;
            case CodeDivi:
                inputConnection.commitText("÷", 1);
                break;
            case CodePlus:
                inputConnection.commitText("＋", 1);
                break;
            case CodeMinus:
                inputConnection.commitText("－", 1);
                break;
            case CodeB1:
                inputConnection.commitText("◆", 1);
                break;
            case CodeB2:
                inputConnection.commitText("▲", 1);
                break;
            case CodeB3:
                inputConnection.commitText("■", 1);
                break;
            case CodeB4:
                inputConnection.commitText("●", 1);
                break;


                default:
                char c = (char)primaryCode;
                inputConnection.commitText(String.valueOf(c),1);

        }






    }






    @Override
    public void onText(CharSequence text) {

    }

    @Override
    public void swipeLeft() {

    }

    @Override
    public void swipeRight() {

    }

    @Override
    public void swipeDown() {

    }

    @Override
    public void swipeUp() {

    }
}
