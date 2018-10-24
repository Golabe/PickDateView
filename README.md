# PickDateView
# 日期选择器

## 未完成 实现了Dialog弹窗
![](https://github.com/Golabe/PickDateView/blob/master/images/image1.png?raw=true)

# 使用

```java
  DatePickerPop datePickerPop = new DatePickerPop.Builder(this)
                 .maxYear(2050)
                 .minYear(1900)
                 .defaultData("2012-02-20")
                 .textSize(16)
                 .textUnselectedColor(Color.parseColor("#CCCCCC"))
                 .textSelectedColor(Color.parseColor("#000000"))
                 .cancelColor(Color.parseColor("#f45151"))
                 .confirmColor(Color.parseColor("#000000"))
                 .btnTextSize(12)
                 .cancel("取消")
                 .confirm("确定")
                 .bgColor(Color.parseColor("#FFFFFF"))
                 .confirmListener(new OnConfirmListener() {
                     @Override
                     public void onConfirm(View v) {
                         Toast.makeText(MainActivity.this, "confirm", Toast.LENGTH_LONG).show();
                     }
                 })
                 .cancelListener(new OnCancelListener() {
                     @Override
                     public void onCancel() {
                         Toast.makeText(MainActivity.this, "cancel", Toast.LENGTH_LONG).show();
                     }
                 })
                 .build();
```