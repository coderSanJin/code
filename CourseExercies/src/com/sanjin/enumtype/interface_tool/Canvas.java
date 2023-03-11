package com.sanjin.enumtype.interface_tool;

/**
 * 在这个示例中，我们定义了一个接口 Drawable，
 * 并在 Circle 和 Square 类中实现了该接口。
 * 这样，我们可以在 Canvas 类中，把所有实现了 Drawable
 * 接口的对象当做是统一类型的对象，而不用关心它们的具体实现细节。
 */
class Canvas {
    public void drawShapes(Drawable[] shapes) {
        for (Drawable shape : shapes) {
            shape.draw();
        }
    }
}