
public class ImageUtility {

    public static Bitmap reflection(Bitmap mainImage) {
        // gap space between original and reflected
        final int reflectionGap = 0;
        // get image size
        int width = mainImage.getWidth();
        int height = mainImage.getHeight();

        Matrix matrix = new Matrix();
        matrix.preScale(1, -1);

        Bitmap reflectionImage = Bitmap.createBitmap(mainImage, 0,
                height / 2, width, height / 2, matrix, false);

        Bitmap reflectedBitmap = Bitmap.createBitmap(width,
                (height + height / 2), Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(reflectedBitmap);
        canvas.drawBitmap(mainImage, 0, 0, null);
        Paint defaultPaint = new Paint();
        canvas.drawRect(0, height, width, height + reflectionGap, defaultPaint);
        canvas.drawBitmap(reflectionImage, 0, height + reflectionGap, null);
        Paint paint = new Paint();
        LinearGradient shader = new LinearGradient(0,
                mainImage.getHeight(), 0, reflectedBitmap.getHeight()
                + reflectionGap, 0x70ffffff, 0x00ffffff, Shader.TileMode.CLAMP);
        paint.setShader(shader);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        canvas.drawRect(0, height, width, reflectedBitmap.getHeight()
                + reflectionGap, paint);

        return reflectedBitmap;
    }


    public static Bitmap getOnlyReflection(Bitmap mainImage) {

        // get image size
        int width = mainImage.getWidth();
        int height = mainImage.getHeight();

        Matrix matrix = new Matrix();
        matrix.preScale(1, -1);

        Bitmap reflectionImage = Bitmap.createBitmap(mainImage, 0,
                height / 2, width, height / 2, matrix, false);

        Bitmap reflectedBitmap = Bitmap.createBitmap(width,
                ( height / 2), Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(reflectedBitmap);
        canvas.drawBitmap(mainImage, 0, 0, null);
        //Paint defaultPaint = new Paint();
        //canvas.drawRect(0, height, width, height, defaultPaint);
        canvas.drawBitmap(reflectionImage, 0, 0, null);
        Paint paint = new Paint();
        LinearGradient shader = new LinearGradient(0,
                0, 0, reflectedBitmap.getHeight(), 0x70ffffff, 0x00ffffff, Shader.TileMode.CLAMP);
        paint.setShader(shader);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        canvas.drawRect(0, 0, width, reflectedBitmap.getHeight(), paint);

        paint = new Paint();
        paint.setColor(Color.BLUE);
        canvas.drawLine(0,0,width,0,paint);



        return reflectedBitmap;
    }
}
