package com.hendraanggrian.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;

import com.hendraanggrian.appcompat.internal.SocialViewImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView;

/**
 * {@link android.widget.MultiAutoCompleteTextView} with hashtag, mention, and hyperlink support.
 *
 * @see SocialView
 */
public class SocialAutoCompleteTextView extends AppCompatMultiAutoCompleteTextView implements SocialView {

    private final SocialView impl;

    // TODO: should check for symbols closest to cursor, not s[start]
    @SuppressWarnings("FieldCanBeLocal")
    private final TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (!TextUtils.isEmpty(s) && start < s.length()) {
                switch (s.charAt(start)) {
                    case '#':
                        if (getAdapter() != hashtagAdapter) {
                            setAdapter(hashtagAdapter);
                        }
                        break;
                    case '@':
                        if (getAdapter() != mentionAdapter) {
                            setAdapter(mentionAdapter);
                        }
                        break;
                }
            }
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };

    private ArrayAdapter hashtagAdapter;
    private ArrayAdapter mentionAdapter;

    public SocialAutoCompleteTextView(Context context) {
        this(context, null);
    }

    public SocialAutoCompleteTextView(Context context, AttributeSet attrs) {
        this(context, attrs, androidx.appcompat.R.attr.autoCompleteTextViewStyle);
    }

    public SocialAutoCompleteTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        impl = new SocialViewImpl(this, attrs);
        addTextChangedListener(textWatcher);
        setTokenizer(new CharTokenizer());
    }

    @Nullable
    public ArrayAdapter getHashtagAdapter() {
        return hashtagAdapter;
    }

    public void setHashtagAdapter(@Nullable ArrayAdapter adapter) {
        hashtagAdapter = adapter;
    }

    @Nullable
    public ArrayAdapter getMentionAdapter() {
        return mentionAdapter;
    }

    public void setMentionAdapter(@Nullable ArrayAdapter adapter) {
        mentionAdapter = adapter;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isHashtagEnabled() {
        return impl.isHashtagEnabled();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setHashtagEnabled(boolean enabled) {
        impl.setHashtagEnabled(enabled);
        setTokenizer(new CharTokenizer());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isMentionEnabled() {
        return impl.isMentionEnabled();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setMentionEnabled(boolean enabled) {
        impl.setMentionEnabled(enabled);
        setTokenizer(new CharTokenizer());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isHyperlinkEnabled() {
        return impl.isHyperlinkEnabled();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setHyperlinkEnabled(boolean enabled) {
        impl.setHyperlinkEnabled(enabled);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ColorStateList getHashtagColors() {
        return impl.getHashtagColors();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setHashtagColors(@NonNull ColorStateList colors) {
        impl.setHashtagColors(colors);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ColorStateList getMentionColors() {
        return impl.getMentionColors();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setMentionColors(@NonNull ColorStateList colors) {
        impl.setMentionColors(colors);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ColorStateList getHyperlinkColors() {
        return impl.getHyperlinkColors();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setHyperlinkColors(@NonNull ColorStateList colors) {
        impl.setHyperlinkColors(colors);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getHashtagColor() {
        return impl.getHyperlinkColor();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setHashtagColor(int color) {
        impl.setHyperlinkColor(color);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getMentionColor() {
        return impl.getMentionColor();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setMentionColor(int color) {
        impl.setMentionColor(color);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getHyperlinkColor() {
        return impl.getHyperlinkColor();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setHyperlinkColor(int color) {
        impl.setHyperlinkColor(color);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setOnHashtagClickListener(@Nullable SocialView.OnClickListener listener) {
        impl.setOnHashtagClickListener(listener);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setOnMentionClickListener(@Nullable SocialView.OnClickListener listener) {
        impl.setOnMentionClickListener(listener);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setOnHyperlinkClickListener(@Nullable SocialView.OnClickListener listener) {
        impl.setOnHashtagClickListener(listener);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setHashtagTextChangedListener(@Nullable OnChangedListener listener) {
        impl.setHashtagTextChangedListener(listener);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setMentionTextChangedListener(@Nullable OnChangedListener listener) {
        impl.setMentionTextChangedListener(listener);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> getHashtags() {
        return impl.getHashtags();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> getMentions() {
        return impl.getMentions();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> getHyperlinks() {
        return impl.getHyperlinks();
    }

    /**
     * While {@link android.widget.MultiAutoCompleteTextView.CommaTokenizer} tracks only comma symbol,
     * `CharTokenizer` can track multiple characters, in this instance, are hashtag and at symbol.
     */
    private class CharTokenizer implements Tokenizer {

        private final Collection<Character> chars = new ArrayList<>();

        CharTokenizer() {
            if (isHashtagEnabled()) {
                chars.add('#');
            }
            if (isMentionEnabled()) {
                chars.add('@');
            }
        }

        @Override
        public int findTokenStart(CharSequence text, int cursor) {
            int i = cursor;
            while (i > 0 && !chars.contains(text.charAt(i - 1))) {
                i--;
            }
            while (i < cursor && text.charAt(i) == ' ') {
                i++;
            }
            // imperfect fix for dropdown still showing without symbol found
            if (i == 0 && isPopupShowing()) {
                dismissDropDown();
            }
            return i;
        }

        @Override
        public int findTokenEnd(CharSequence text, int cursor) {
            int i = cursor;
            final int len = text.length();
            while (i < len) {
                if (chars.contains(text.charAt(i))) {
                    return i;
                } else {
                    i++;
                }
            }
            return len;
        }

        @Override
        public CharSequence terminateToken(CharSequence text) {
            int i = text.length();
            while (i > 0 && text.charAt(i - 1) == ' ') {
                i--;
            }
            if (i > 0 && chars.contains(text.charAt(i - 1))) {
                return text;
            } else {
                if (text instanceof Spanned) {
                    final Spannable sp = new SpannableString(text + " ");
                    TextUtils.copySpansFrom((Spanned) text, 0, text.length(), Object.class, sp, 0);
                    return sp;
                } else {
                    return text + " ";
                }
            }
        }
    }
}