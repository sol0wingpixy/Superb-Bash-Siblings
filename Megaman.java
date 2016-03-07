public class Megaman extends Character
{
   public Megaman(int x,int y)
   {
      super(x,y,25,25);
      weight=110;
   }
   public void jump()
   {
      this.setInAir(true);
      this.setVelY(-1.4);
   }
   public void step(boolean right)
   {
      double off=.03;
      if(!right)
      {
         off*=-1;
      }
      setVelX(getVelX()+off);
   }
   public void attack(int dir,boolean light)
   {
      Rect rect=hitbox.getBoxes()[0];
      if(light)
      {
         switch(dir)
         {
            case 0://different for each fighter
               atk=new Hitbox(new Rect[]{new Rect(rect.getLeft(),rect.getTop()-rect.getHeight(),rect.getRight(),rect.getTop())},"atk");
               atkUp=true;
               atkDir=0;
               break;
            case 1:
               atk=new Hitbox(new Rect[]{new Rect(rect.getRight(),rect.getTop(),rect.getRight()+rect.getWidth(),rect.getBottom())},"atk");
               atkUp=true;
               atkDir=1;
               break;
            case 2:
               atk=new Hitbox(new Rect[]{new Rect(rect.getLeft(),rect.getBottom()+1,rect.getRight(),rect.getBottom()+rect.getHeight()+1)},"atk");
               atkUp=true;
               atkDir=2;
               break;
            case 3:
               atk=new Hitbox(new Rect[]{new Rect(rect.getLeft()-rect.getWidth(),rect.getTop(),rect.getLeft(),rect.getBottom())},"atk");
               atkUp=true;
               atkDir=3;
               break;
            case 4:
               atk=new Hitbox(new Rect[]{new Rect(rect.getLeft()-rect.getWidth()/4,rect.getTop()-rect.getHeight()/4,rect.getRight()+rect.getWidth()/4,rect.getBottom()+rect.getHeight()/4)},"atk");
               atkUp=true;
               atkDir=4;
               break;
            default: 
               atk=null;
               atkUp=false;
               atkDir=5;
               break;
         }
      }
      else
      {
         switch(dir)
         {
            case 0://different for each fighter
               atk=new Hitbox(new Rect[]{new Rect(rect.getLeft(),rect.getTop()-rect.getHeight(),rect.getRight(),rect.getTop())},"atk");
               atkUp=true;
               break;
            case 1:
               atk=new Hitbox(new Rect[]{new Rect(rect.getRight(),rect.getTop(),rect.getRight()+rect.getWidth(),rect.getBottom())},"atk");
               atkUp=true;
               break;
            case 2:
               atk=new Hitbox(new Rect[]{new Rect(rect.getLeft(),rect.getBottom()+1,rect.getRight(),rect.getBottom()+rect.getHeight()+1)},"atk");
               atkUp=true;
               break;
            case 3:
               atk=new Hitbox(new Rect[]{new Rect(rect.getLeft()-rect.getWidth(),rect.getTop(),rect.getLeft(),rect.getBottom())},"atk");
               atkUp=true;
               break;
            case 4:
               atk=new Hitbox(new Rect[]{new Rect(rect.getLeft()-rect.getWidth()/4,rect.getTop()-rect.getHeight()/4,rect.getRight()+rect.getWidth()/4,rect.getBottom()+rect.getHeight()/4)},"atk");
               atkUp=true;
               break;
            default: 
               atk=null;
               atkUp=false;
               break;
         }
            
      }
   }
   public double[] getAtkPow(int dir,boolean light,boolean kBack)
   {
      if(light)
      {
         switch(dir)
         {
            case 0:
               if(kBack)
                  return new double[]{-1,0};//up 1
               return new double[]{4.6};//5%
            case 1:
               if(kBack)
                  return new double[]{-.5,1.5};//up .5 right 1.5
               return new double[]{6};//5%
            case 2:
               if(kBack)
                  return new double[]{1.5,0};//down 1.5
               return new double[]{11};//10%
            case 3:
               if(kBack)
                  return new double[]{-.5,-1.5};//up .5 left 1.5
               return new double[]{6};//5%
            case 4:
               if(kBack)
                  return new double[]{-1,0};//up 1
               return new double[]{4.3};//5%
         }
      }
      else
      {
         switch(dir)
         {
            case 0:
               if(kBack)
                  return new double[]{-2,0};//up 2
               return new double[]{2};//5%
            case 1:
               if(kBack)
                  return new double[]{-.5,2.5};//up .5 right 2.5
               return new double[]{3};//5%
            case 2:
               if(kBack)
                  return new double[]{5,0};//down 5
               return new double[]{5};//10%
            case 3:
               if(kBack)
                  return new double[]{-.5,-2.5};//up .5 left 2.5
               return new double[]{3};//5%
            case 4:
               if(kBack)
                  return new double[]{-2,0};//up 2
               return new double[]{1.5};//5%
         }
      }
      return null;
   }
   public boolean getAtkUp()
   {
      if(getAtkDir()==1)
         atk.offset(100,0);
      if(getAtkDir()==3)
         atk.offset(-100,0);
      return atkUp;
   }
}