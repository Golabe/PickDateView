# PickDateView
# 日期选择器

![](https://img.shields.io/github/stars/pandao/editor.md.svg)
![](https://img.shields.io/github/forks/pandao/editor.md.svg)
![](https://img.shields.io/github/tag/pandao/editor.md.svg)
![](https://img.shields.io/github/release/pandao/editor.md.svg)
![](https://img.shields.io/github/issues/pandao/editor.md.svg)
![](https://img.shields.io/bower/v/editor.md.svg)

## 未完成 实现了Dialog弹窗

# 使用


```java
 DatePickerPop datePickerPop = new DatePickerPop.Builder(this)
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