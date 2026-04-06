function App() {
  return (
    <div className="min-h-screen bg-gray-50">
      {/* Header */}
      <header className="bg-white shadow-sm">
        <div className="max-w-7xl mx-auto px-4 py-4 sm:px-6 lg:px-8">
          <div className="flex items-center justify-between">
            <h1 className="text-2xl font-bold text-primary-600">Learning Clinic</h1>
            <nav className="flex gap-4">
              <button className="px-4 py-2 text-gray-600 hover:text-primary-600 transition-colors">
                로그인
              </button>
              <button className="px-4 py-2 bg-primary-500 text-white rounded-lg hover:bg-primary-600 transition-colors">
                시작하기
              </button>
            </nav>
          </div>
        </div>
      </header>

      {/* Hero Section */}
      <main className="max-w-7xl mx-auto px-4 py-16 sm:px-6 lg:px-8">
        <div className="text-center">
          <h2 className="text-4xl font-bold text-gray-900 sm:text-5xl">
            멘토와 멘티, 서로를 알고 시작하는
            <br />
            <span className="text-primary-500">진단형 멘토링 플랫폼</span>
          </h2>
          <p className="mt-6 text-lg text-gray-600 max-w-2xl mx-auto">
            기관 의뢰와 멘티 자가진단을 기반으로 AI가 분석하고,
            <br />
            멘토가 맞춤 제안서를 작성합니다.
          </p>
          <div className="mt-10 flex justify-center gap-4">
            <button className="px-8 py-3 bg-primary-500 text-white rounded-lg font-semibold hover:bg-primary-600 transition-colors shadow-lg">
              멘토로 시작하기
            </button>
            <button className="px-8 py-3 bg-white text-primary-600 border-2 border-primary-500 rounded-lg font-semibold hover:bg-primary-50 transition-colors">
              멘티로 시작하기
            </button>
          </div>
        </div>

        {/* Features */}
        <div className="mt-24 grid grid-cols-1 md:grid-cols-3 gap-8">
          <div className="bg-white p-6 rounded-xl shadow-md">
            <div className="w-12 h-12 bg-primary-100 rounded-lg flex items-center justify-center mb-4">
              <svg className="w-6 h-6 text-primary-600" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M9 12h6m-6 4h6m2 5H7a2 2 0 01-2-2V5a2 2 0 012-2h5.586a1 1 0 01.707.293l5.414 5.414a1 1 0 01.293.707V19a2 2 0 01-2 2z" />
              </svg>
            </div>
            <h3 className="text-xl font-semibold text-gray-900 mb-2">역량 체크업 리포트</h3>
            <p className="text-gray-600">
              기관 의뢰서와 멘티 자가진단을 바탕으로 AI가 초안을 작성하고, 멘토가 최종 확정합니다.
            </p>
          </div>

          <div className="bg-white p-6 rounded-xl shadow-md">
            <div className="w-12 h-12 bg-primary-100 rounded-lg flex items-center justify-center mb-4">
              <svg className="w-6 h-6 text-primary-600" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M17 20h5v-2a3 3 0 00-5.356-1.857M17 20H7m10 0v-2c0-.656-.126-1.283-.356-1.857M7 20H2v-2a3 3 0 015.356-1.857M7 20v-2c0-.656.126-1.283.356-1.857m0 0a5.002 5.002 0 019.288 0M15 7a3 3 0 11-6 0 3 3 0 016 0zm6 3a2 2 0 11-4 0 2 2 0 014 0zM7 10a2 2 0 11-4 0 2 2 0 014 0z" />
              </svg>
            </div>
            <h3 className="text-xl font-semibold text-gray-900 mb-2">Fit 요약</h3>
            <p className="text-gray-600">
              멘토 스타일 카드와 멘티 니즈를 분석하여 궁합 점수와 예상 시너지를 제공합니다.
            </p>
          </div>

          <div className="bg-white p-6 rounded-xl shadow-md">
            <div className="w-12 h-12 bg-primary-100 rounded-lg flex items-center justify-center mb-4">
              <svg className="w-6 h-6 text-primary-600" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M9 5H7a2 2 0 00-2 2v12a2 2 0 002 2h10a2 2 0 002-2V7a2 2 0 00-2-2h-2M9 5a2 2 0 002 2h2a2 2 0 002-2M9 5a2 2 0 012-2h2a2 2 0 012 2m-3 7h3m-3 4h3m-6-4h.01M9 16h.01" />
              </svg>
            </div>
            <h3 className="text-xl font-semibold text-gray-900 mb-2">멘토링 제안서</h3>
            <p className="text-gray-600">
              목표, 커리큘럼, 일정, 예상 성과를 담은 제안서를 멘티에게 전달하고 수락을 받습니다.
            </p>
          </div>
        </div>

        {/* Flow Section */}
        <div className="mt-24">
          <h3 className="text-2xl font-bold text-gray-900 text-center mb-12">멘토링 진행 흐름</h3>
          <div className="flex flex-col md:flex-row items-center justify-center gap-4">
            {['기관 의뢰', '멘티 자가진단', '역량 체크업', '제안서 작성', '멘티 수락', '멘토링 시작'].map((step, index) => (
              <div key={step} className="flex items-center">
                <div className="flex flex-col items-center">
                  <div className="w-10 h-10 bg-primary-500 text-white rounded-full flex items-center justify-center font-bold">
                    {index + 1}
                  </div>
                  <span className="mt-2 text-sm text-gray-600">{step}</span>
                </div>
                {index < 5 && (
                  <div className="hidden md:block w-12 h-0.5 bg-primary-200 mx-2" />
                )}
              </div>
            ))}
          </div>
        </div>
      </main>

      {/* Footer */}
      <footer className="bg-gray-900 text-white mt-24">
        <div className="max-w-7xl mx-auto px-4 py-12 sm:px-6 lg:px-8">
          <div className="text-center">
            <h4 className="text-xl font-bold mb-2">Learning Clinic</h4>
            <p className="text-gray-400">멘토 중심 진단 제안형 멘토링 플랫폼</p>
          </div>
        </div>
      </footer>
    </div>
  )
}

export default App
