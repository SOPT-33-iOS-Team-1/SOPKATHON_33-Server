package org.sopt.sopkerton.user.dto.response;

import java.util.List;

public record DetailView(
        List<String> volunteers,
        List<String> programs,
        List<String> certifications
) {
}
